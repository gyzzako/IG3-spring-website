package be.henallux.java.website.controller;

import be.henallux.java.website.dataAccess.dao.ProductDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/category/{id}")
public class ProductsListByCategoryController {
    private ProductDataAccess productDAO;

    @Autowired
    public ProductsListByCategoryController(ProductDataAccess productDAO){
        this.productDAO = productDAO;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String home(Model model, Locale locale, @PathVariable Integer id){
        model.addAttribute("title", "Home");
        model.addAttribute("products", productDAO.getAllProductByCategoryId(id));
        return "integrated:products";
    }
}
