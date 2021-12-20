package be.henallux.java.website.controller;

import be.henallux.java.website.dataAccess.dao.CategoryDataAccess;
import be.henallux.java.website.dataAccess.dao.ProductDataAccess;
import be.henallux.java.website.dataAccess.dao.TranslationDataAccess;
import be.henallux.java.website.model.Category;
import be.henallux.java.website.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value="/category/{id}")
public class ProductsListByCategoryController {
    private ProductDataAccess productDAO;

    @Autowired
    public ProductsListByCategoryController(ProductDataAccess productDAO){
        this.productDAO = productDAO;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String home(Model model,@PathVariable Integer id){
        model.addAttribute("title", "Home");
        model.addAttribute("products", productDAO.getAllProductByCategoryId(id));
        return "integrated:products";
    }
}
