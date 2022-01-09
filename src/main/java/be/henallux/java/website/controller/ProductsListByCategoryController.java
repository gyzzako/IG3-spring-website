package be.henallux.java.website.controller;

import be.henallux.java.website.model.ProductEntity;
import be.henallux.java.website.services.DiscountService;
import be.henallux.java.website.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping(value="/category/")
public class ProductsListByCategoryController {
    private ProductService productService;
    private MessageSource messageSource;
    private DiscountService discountService;

    @Autowired
    public ProductsListByCategoryController(ProductService productService,MessageSource messageSource, DiscountService discountService){
        this.productService = productService;
        this.messageSource = messageSource;
        this.discountService = discountService;
    }

    @RequestMapping(value = "{id}", method=RequestMethod.GET)
    public String productsList(Model model, Locale locale, @PathVariable Integer id){
        model.addAttribute("title", messageSource.getMessage("home", new Object[0], locale));
        ArrayList<ProductEntity> products = productService.getAllProductByCategoryId(id);
        products.forEach(product -> product.setPriceAfterDiscountCalculation(discountService.getPriceOnDiscount(product)));
        model.addAttribute("products", products);
        return "integrated:products";
    }
}
