package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Translation {

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

    public Translation(Integer translation_id,String label,Language language,Category category){
        this.category = category;
        this.label = label;
        this.translation_id = translation_id;
        this.language = language;
    }

    public Translation(){}

    public Integer getTranslation_id() {
        return translation_id;
    }

    public void setTranslation_id(Integer translation_id) {
        this.translation_id = translation_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
