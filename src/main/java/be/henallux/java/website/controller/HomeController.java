package be.henallux.java.website.controller;

import be.henallux.java.website.dataAccess.dao.CategoryDataAccess;
import be.henallux.java.website.dataAccess.dao.ProductDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/")
public class HomeController {
    private ProductDataAccess productDAO;
    private CategoryDataAccess categoryDAO;

    @Autowired
    public HomeController(ProductDataAccess productDAO, CategoryDataAccess categoryDAO){
        this.productDAO = productDAO;
        this.categoryDAO = categoryDAO;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String home(Model model,@RequestParam(defaultValue = "Guitare") String category){
        model.addAttribute("title", "Home");
        model.addAttribute("categories", categoryDAO.getAllCategories());
        model.addAttribute("products", productDAO.getAllProductByCategory(category));
        return "integrated:home";
    }
}
