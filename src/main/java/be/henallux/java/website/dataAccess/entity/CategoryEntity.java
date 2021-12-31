package be.henallux.java.website.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity {
    //region Attributs
    @Id
    @Column(name = "category_id")
    private Integer categorId;
    //endregion

    public CategoryEntity(){

    }

    //region GETTERS AND SETTERS
    public Integer getCategoryId(){
        return this.categorId;
    }

    public void setCategoryId(Integer categorId){
        this.categorId = categorId;
    }
    //endregion
}
