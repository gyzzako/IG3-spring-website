package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Translation {
    //region Attributs
    @NotNull
    @Min(value = 1)
    private Integer translationId;

    @NotNull
    @Size(min = 5, max = 50)
    private String label;

    @NotNull
    private Language language;

    @NotNull
    private Category category;
    //endregion


    //region Constructors
    public Translation(Integer translationId, String label, Language language, Category category){
        setCategory(category);
        setLabel(label);
        setTranslationId(translationId);
        setLanguage(language);
    }

    public Translation(){

    }
    //endregion


    //region GETTERS
    public Integer getTranslationId() {
        return translationId;
    }

    public String getLabel() {
        return label;
    }

    public Language getLanguage() {
        return language;
    }

    public Category getCategory() {
        return category;
    }
    //endregion


    //region SETTERS
    public void setTranslationId(Integer translationId) {
        this.translationId = translationId;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    //endregion

}
