package be.henallux.java.website.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "translation")
public class TranslationEntity {
    //region Attributs
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
    //endregion

    public TranslationEntity(){

    }

    //region GETTERS
    public Integer getTranslation_id() {
        return translation_id;
    }

    public String getLabel() {
        return label;
    }

    public LanguageEntity getLanguage_fk() {
        return language_fk;
    }

    public CategoryEntity getCategory_fk() {
        return category_fk;
    }
    //endregion

    //region SETTERS
    public void setTranslation_id(Integer translation_id) {
        this.translation_id = translation_id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setLanguage_fk(LanguageEntity language_fk) {
        this.language_fk = language_fk;
    }

    public void setCategory_fk(CategoryEntity category_fk) {
        this.category_fk = category_fk;
    }
    //endregion
}
