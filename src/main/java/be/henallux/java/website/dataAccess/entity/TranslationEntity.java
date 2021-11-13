package be.henallux.java.website.dataAccess.entity;

import javax.persistence.*;

@Entity
public class TranslationEntity {


    @Id
    @Column(name = "translation_id")
    private Integer translation_id;

    @Column(name = "label")
    private String label;

    @JoinColumn(name = "language_fk", referencedColumnName = "language_id")
    @ManyToOne
    private LanguageEntity language_fk;

    @JoinColumn(name = "category_fk", referencedColumnName = "category_id")
    @ManyToOne
    private CategoryEntity category_fk;

    //---Getters and Setters.

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

    public LanguageEntity getLanguage_fk() {
        return language_fk;
    }

    public void setLanguage_fk(LanguageEntity language_fk) {
        this.language_fk = language_fk;
    }

    public CategoryEntity getCategory_fk() {
        return category_fk;
    }

    public void setCategory_fk(CategoryEntity category_fk) {
        this.category_fk = category_fk;
    }
}
