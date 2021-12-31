package be.henallux.java.website.controller;

import be.henallux.java.website.Constants;
import be.henallux.java.website.model.Cart;
import be.henallux.java.website.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Locale;

@Controller
@RequestMapping(value="/cart")
@SessionAttributes({Constants.CURRENT_CART})
public class CartController {
    private MessageSource messageSource;

    @Autowired
    public CartController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cartLine(){
        return new Cart();
    }

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model, Locale locale, @ModelAttribute(value=Constants.CURRENT_CART) Cart cart){
        model.addAttribute("title", messageSource.getMessage("cart", new Object[0], locale));
        model.addAttribute("cartItem",new CartItem());
        model.addAttribute("cart", cart);
        return "integrated:cart";
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="cartItem") CartItem cartItem, @ModelAttribute(value=Constants.CURRENT_CART) Cart cart){
        if(cart.getProducts().containsKey(cartItem.getProductId())){
            Integer oldQuantity = cart.getProducts().get(cartItem.getProductId()).getQuantity();
            cart.getProducts().get(cartItem.getProductId()).setQuantity(cartItem.getQuantity()+oldQuantity); //ajoute la nouvelle quantité à l'ancienne
        }else{
            cart.addProduct(cartItem.getProductId(), cartItem);
        }
        return "redirect:/cart";
    }

    @RequestMapping(value="/quantityUpdate", method=RequestMethod.POST)
    public String updateProductQuantity(@ModelAttribute(value="cartItem") CartItem cartItem, @ModelAttribute(value=Constants.CURRENT_CART) Cart cart){
        cart.getProducts().get(cartItem.getProductId()).setQuantity(cartItem.getQuantity());
        return "redirect:/cart";
    }
}
