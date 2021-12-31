package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Language {
    //region Attributs
    @NotNull
    @Min(value = 1)
    private Integer languageId;

    @NotNull
    private String locale;
    //endregion


    //region Constructors
    public Language(Integer languageId){
        setLanguageId(languageId);
    }

    public Language(){

    }
    //endregion


    //region GETTERS
    public Integer getLanguageId() {
        return languageId;
    }
    public String getLocale() {
        return locale;
    }
    //endregion


    //region SETTERS
    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }
    public void setLocale(String locale) {
        this.locale = locale;
    }
    //endregion
}
