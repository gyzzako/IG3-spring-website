package be.henallux.java.website.controller;

import be.henallux.java.website.dataAccess.dao.CategoryDataAccess;
import be.henallux.java.website.dataAccess.dao.ProductDataAccess;
import be.henallux.java.website.dataAccess.dao.TranslationDataAccess;
import be.henallux.java.website.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/product/{id}")
public class ProductDescriptionController {
    private ProductDataAccess productDAO;


    @Autowired
    public ProductDescriptionController(ProductDataAccess productDAO){
        this.productDAO = productDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String userRegistration(Model model, @PathVariable Integer id){
        model.addAttribute("product", productDAO.getProductById(id));
        return "integrated:productDescription";
    }

}
