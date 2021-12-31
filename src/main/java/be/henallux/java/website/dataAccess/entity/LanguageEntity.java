package be.henallux.java.website.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class LanguageEntity {
    //region Attributs
    @Id
    @Column(name = "language_id")
    private Integer languageId;

    @Column(name = "locale")
    private String locale;
    //endregion

    public LanguageEntity(){

    }

    //---Getter and setter
    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    //endregion
}
