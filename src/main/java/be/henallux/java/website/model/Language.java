package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Language {
    //region Attributs
    @NotNull
    @Min(value = 1)
    private Integer language_id;
    //endregion


    //region Constructors
    public Language(Integer language_id){
        setLanguage_id(language_id);
    }

    public Language(){
        this(null);
    }
    //endregion


    //region GETTERS
    public Integer getLanguage_id() {
        return language_id;
    }
    //endregion


    //region SETTERS
    public void setLanguage_id(Integer language_id) {
        this.language_id = language_id;
    }
    //endregion
}
