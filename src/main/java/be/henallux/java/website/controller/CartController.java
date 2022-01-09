package be.henallux.java.website.controller;

import be.henallux.java.website.Constants;
import be.henallux.java.website.model.*;
import be.henallux.java.website.services.DiscountService;
import be.henallux.java.website.services.ProductService;
import be.henallux.java.website.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping(value="/cart")
@SessionAttributes({Constants.CURRENT_CART})
public class CartController {
    private MessageSource messageSource;
    private PurchaseService purchaseService;
    private DiscountService discountService;
    private ProductService productService;

    @Autowired
    public CartController(MessageSource messageSource, PurchaseService purchaseService, DiscountService discountService,ProductService productService){
        this.messageSource = messageSource;
        this.purchaseService = purchaseService;
        this.discountService = discountService;
        this.productService = productService;
    }

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cartLine(){
        return new Cart();
    }


    @RequestMapping(method= RequestMethod.GET)
    public String cart(Model model, Locale locale, @ModelAttribute(value=Constants.CURRENT_CART) Cart cart){
        model.addAttribute("title", messageSource.getMessage("cart", new Object[0], locale));
        model.addAttribute("cartItem",new CartItem());
        model.addAttribute("cart", cart);
        model.addAttribute("locale", locale);
        return "integrated:cart";
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="cartItem") CartItem cartItem, @ModelAttribute(value=Constants.CURRENT_CART) Cart cart, HttpServletRequest request){
        if(cartItem.getQuantity() > 0){
            ProductEntity product = productService.getProductById(cartItem.getProductId());
            Float priceAfterDiscount = discountService.getPriceOnDiscount(product);
            product.setPriceAfterDiscountCalculation(priceAfterDiscount);
            OrderLine orderLine = new OrderLine(null, priceAfterDiscount, cartItem.getQuantity(), null, product);

            if(cart.getProducts().containsKey(product.getProductId())){
                Integer oldQuantity = cart.getProducts().get(product.getProductId()).getQuantity();
                cart.getProducts().get(product.getProductId()).setQuantity(cartItem.getQuantity()+oldQuantity); //ajoute la nouvelle quantité à l'ancienne
            }else{
                cart.addProduct(product.getProductId(), orderLine);
            }
            return "redirect:/cart";
        }else{
            return Optional.ofNullable(request.getHeader("Referer")).map(requestUrl -> "redirect:" + requestUrl).orElse("/"); //redirige vers la page si possible sinon vers l'accueil
        }

    }

    @RequestMapping(value="/quantityUpdate", method=RequestMethod.POST)
    public String updateProductQuantity(@ModelAttribute(value="cartItem") CartItem cartItem, @ModelAttribute(value=Constants.CURRENT_CART) Cart cart, HttpServletRequest request){
        if(cartItem.getQuantity() > 0){
            cart.getProducts().get(cartItem.getProductId()).setQuantity(cartItem.getQuantity());
            return "redirect:/cart";
        }else{
            return Optional.ofNullable(request.getHeader("Referer")).map(requestUrl -> "redirect:" + requestUrl).orElse("/"); //redirige vers la page si possible sinon vers l'accueil
        }
    }

    @RequestMapping(value="/removeItem", method=RequestMethod.POST)
    public String removeItem(@ModelAttribute(value="cartItem") CartItem cartItem, @ModelAttribute(value=Constants.CURRENT_CART) Cart cart){
        cart.getProducts().remove(cartItem.getProductId());
        return "redirect:/cart";
    }

    @RequestMapping(value="/saveCart", method=RequestMethod.POST)
    public String saveCart(@ModelAttribute(value=Constants.CURRENT_CART) Cart cart, HttpSession session){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = (Customer) auth.getPrincipal();

        Order order = purchaseService.savePurchase(cart.getProducts(), customer);

        Order orderFromSession = (Order) session.getAttribute("currentOrder");
        if(orderFromSession == null){
            session.setAttribute("currentOrder", order);
        }else{
            if(!orderFromSession.getOrderId().equals(order.getOrderId())){
                session.removeAttribute("currentOrder");
                session.setAttribute("currentOrder", order);
            }
        }
        return "redirect:/paypalFormData";
    }

    @RequestMapping(value="/paymentSuccess", method=RequestMethod.GET)
    public String paymentSuccess(@ModelAttribute(value=Constants.CURRENT_CART) Cart cart, HttpSession session){
        cart.getProducts().clear();
        Order order = (Order) session.getAttribute("currentOrder");
        if(order != null){
            purchaseService.modifyOrderToPaid(order.getOrderId()); //pas sécurisé avec ce système car l'utilisateur peut revenir sur ce lien sans payer et sa commande sera marquée comme payée
        }
        return "redirect:/";
    }

    @RequestMapping(value="/paymentFailed", method=RequestMethod.GET)
    public String paymentFailed(HttpSession session){
        return "redirect:/cart";
    }
}