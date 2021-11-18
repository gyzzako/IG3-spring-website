package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Translation {
    //region Attributs
    @NotNull
    @Min(value = 1)
    private Integer translation_id;

    @NotNull
    @Size(min = 5, max = 50)
    private String label;

    @NotNull
    private Language language;

    @NotNull
    private Category category;
    //endregion


    //region Constructors
    public Translation(Integer translation_id, String label, Language language, Category category){
        setCategory(category);
        setLabel(label);
        setTranslation_id(translation_id);
        setLanguage(language);
    }

    public Translation(){
        this(null, null, null, null);
    }
    //endregion


    //region GETTERS
    public Integer getTranslation_id() {
        return translation_id;
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
    public void setTranslation_id(Integer translation_id) {
        this.translation_id = translation_id;
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
