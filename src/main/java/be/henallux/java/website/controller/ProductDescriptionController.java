package be.henallux.java.website.controller;

import be.henallux.java.website.model.Cart;
import be.henallux.java.website.model.CartItem;
import be.henallux.java.website.model.Product;
import be.henallux.java.website.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value = "/product/{id}")
public class ProductDescriptionController {
    private ProductService productService;
    private MessageSource messageSource;

    @Autowired
    public ProductDescriptionController(ProductService productService, MessageSource messageSource){
        this.productService = productService;
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String userRegistration(Model model, Locale locale, @PathVariable Integer id){
        Product product = productService.getProductById(id);
        model.addAttribute("title", product.getProductName());
        model.addAttribute("product", product);
        model.addAttribute("cartItem",new CartItem());
        return "integrated:productDescription";
    }

}
