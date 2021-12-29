package be.henallux.java.website.controller;

import be.henallux.java.website.dataAccess.dao.TranslationDataAccess;

import be.henallux.java.website.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping(value="/")
public class HomeController {
    private TranslationDataAccess translationDAO;
    private MessageSource messageSource;

    @Autowired
    public HomeController(TranslationDataAccess translationDAO,MessageSource messageSource){
        this.translationDAO = translationDAO;
        this.messageSource = messageSource;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String home(Model model, Locale locale){
        ArrayList<Translation> categoriesTranslations;
        categoriesTranslations = translationDAO.getCategoryTranslationByLanguage(locale.getLanguage());
        model.addAttribute("title", messageSource.getMessage("home", new Object[0], locale));
        model.addAttribute("categories", categoriesTranslations);
        return "integrated:home";
    }
}
