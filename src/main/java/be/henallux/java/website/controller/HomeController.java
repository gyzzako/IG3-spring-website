package be.henallux.java.website.controller;

import be.henallux.java.website.dataAccess.dao.CategoryDataAccess;
import be.henallux.java.website.dataAccess.dao.ProductDataAccess;
import be.henallux.java.website.dataAccess.dao.TranslationDataAccess;
import be.henallux.java.website.model.Category;
import be.henallux.java.website.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
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
    public String home(Model model, @RequestParam(defaultValue = "fr") String locale, @CookieValue(value = "localeCookie", defaultValue="fr") String localeCookie){
        ArrayList<Translation> categoriesTranslations;
        if(localeCookie != null) {
            System.out.println(localeCookie);
        }
        if(locale.equals("en") || (localeCookie != null && localeCookie.equals("en"))) categoriesTranslations = translationDAO.getCategoryTranslationByLanguage(2);
        else categoriesTranslations = translationDAO.getCategoryTranslationByLanguage(1);
        model.addAttribute("title", "Home");
        model.addAttribute("locale", locale);
        model.addAttribute("categories", categoriesTranslations);
        return "integrated:home";
    }
}
