package be.henallux.java.website.services;


import be.henallux.java.website.dataAccess.dao.TranslationDataAccess;

import be.henallux.java.website.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TranslationService {
    private TranslationDataAccess translationDAO;

    @Autowired
    public TranslationService(TranslationDataAccess translationDAO){
        this.translationDAO = translationDAO;
    }

    public ArrayList<Translation> getCategoriesTranslation(String locale){
        return translationDAO.getCategoryTranslationByLanguage(locale);
    }
}
