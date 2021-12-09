package be.henallux.java.website.controller;

import be.henallux.java.website.dataAccess.dao.CategoryDataAccess;
import be.henallux.java.website.dataAccess.dao.ProductDataAccess;
import be.henallux.java.website.dataAccess.dao.TranslationDataAccess;
import be.henallux.java.website.model.Category;
import be.henallux.java.website.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value="/")
public class HomeController {
    private ProductDataAccess productDAO;
    private CategoryDataAccess categoryDAO;
    private TranslationDataAccess translationDAO;

    @Autowired
    public HomeController(ProductDataAccess productDAO, CategoryDataAccess categoryDAO, TranslationDataAccess translationDAO){
        this.productDAO = productDAO;
        this.categoryDAO = categoryDAO;
        this.translationDAO = translationDAO;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String home(Model model,@RequestParam(defaultValue = "1") Integer category, @RequestParam(defaultValue = "fr") String locale){
        ArrayList<Translation> categoriesTranslations;
        if(locale.equals("fr")) categoriesTranslations = translationDAO.getCategoryTranslationByLanguage(1);
        else categoriesTranslations = translationDAO.getCategoryTranslationByLanguage(2);
        model.addAttribute("title", "Home");
        model.addAttribute("categories", categoriesTranslations);
        model.addAttribute("products", productDAO.getAllProductByCategoryId(category));
        return "integrated:home";
    }
}
