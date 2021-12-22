package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.model.Translation;

import java.util.ArrayList;

public interface TranslationDataAccess {
    ArrayList<Translation> getAllTranslations();
    ArrayList<Translation> getCategoryTranslationByLanguage(String locale);
}
