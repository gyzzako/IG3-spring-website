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
public class ProductController {
    private ProductDataAccess productDAO;
    private CategoryDataAccess categoryDAO;
    private TranslationDataAccess translationDAO;

    @Autowired
    public ProductController(ProductDataAccess productDAO, CategoryDataAccess categoryDAO, TranslationDataAccess translationDAO){
        this.productDAO = productDAO;
        this.categoryDAO = categoryDAO;
        this.translationDAO = translationDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String userRegistration(Model model, @PathVariable Integer id, @RequestParam(defaultValue = "fr") String locale){//TODO: traduction fonctionnent que pour page acceuil -> mettre "locale" dans la session ?
        ArrayList<Translation> categoriesTranslations;
        if(locale.equals("fr")) categoriesTranslations = translationDAO.getCategoryTranslationByLanguage(1);
        else categoriesTranslations = translationDAO.getCategoryTranslationByLanguage(2);
        model.addAttribute("categories", categoriesTranslations); //TODO: faire pour qu'on ne doive pas tout le temps faire appel à la db pour réafficher les catégories
        model.addAttribute("product", productDAO.getProductById(id));
        return "integrated:product";
    }

}
