package be.henallux.java.website.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "translation")
public class TranslationEntity {
    //region Attributs
    @Id
    @Column(name = "translation_id")
    private Integer translationId;

    @Column(name = "label")
    private String label;

    @JoinColumn(name = "language_fk", referencedColumnName = "language_id")
    @ManyToOne
    private LanguageEntity language;

    @JoinColumn(name = "category_fk", referencedColumnName = "category_id")
    @ManyToOne
    private CategoryEntity category;
    //endregion

    public TranslationEntity(){

    }

    //region GETTERS

    public Integer getTranslationId() {
        return translationId;
    }

    public String getLabel() {
        return label;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public CategoryEntity getCategory() {
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

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    //endregion
}
