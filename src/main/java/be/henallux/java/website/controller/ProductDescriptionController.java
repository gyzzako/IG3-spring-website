package be.henallux.java.website.controller;

import be.henallux.java.website.dataAccess.dao.ProductDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@RequestMapping(value = "/product/{id}")
public class ProductDescriptionController {
    private ProductDataAccess productDAO;


    @Autowired
    public ProductDescriptionController(ProductDataAccess productDAO){
        this.productDAO = productDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String userRegistration(Model model, Locale locale, @PathVariable Integer id){
        model.addAttribute("product", productDAO.getProductById(id));
        return "integrated:productDescription";
    }

}
