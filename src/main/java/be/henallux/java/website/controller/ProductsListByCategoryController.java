package be.henallux.java.website.controller;

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
@RequestMapping(value="/category/{id}")
public class ProductsListByCategoryController {
    private ProductService productService;
    private MessageSource messageSource;

    @Autowired
    public ProductsListByCategoryController(ProductService productService,MessageSource messageSource){
        this.productService = productService;
        this.messageSource = messageSource;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String home(Model model, Locale locale, @PathVariable Integer id){
        model.addAttribute("title", messageSource.getMessage("home", new Object[0], locale));
        model.addAttribute("products", productService.getAllProductByCategoryId(id));
        return "integrated:products";
    }
}
