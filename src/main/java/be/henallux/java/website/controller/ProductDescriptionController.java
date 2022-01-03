package be.henallux.java.website.controller;

import be.henallux.java.website.model.Cart;
import be.henallux.java.website.model.CartItem;
import be.henallux.java.website.model.Product;
import be.henallux.java.website.services.DiscountService;
import be.henallux.java.website.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/product/")
public class ProductDescriptionController {
    private ProductService productService;
    private MessageSource messageSource;
    private DiscountService discountService;

    @Autowired
    public ProductDescriptionController(ProductService productService, MessageSource messageSource, DiscountService discountService){
        this.productService = productService;
        this.messageSource = messageSource;
        this.discountService = discountService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String productDescription(Model model, @PathVariable Integer id){
        Product product = productService.getProductById(id);
        model.addAttribute("cartItem",new CartItem());
        if(product != null){
            model.addAttribute("title", product.getProductName());
            product.setPriceAfterDiscountCalculation(discountService.getPriceOnDiscount(product));
            model.addAttribute("product", product);
            return "integrated:productDescription";
        }else{
            return "redirect:/";
        }
    }

}
