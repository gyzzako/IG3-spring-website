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
    private Integer category_id;

    @Column(name = "name")
    private String name;
    //endregion

    public CategoryEntity(){

    }

    //region GETTERS AND SETTERS
    public Integer getCategory_id(){
        return this.category_id;
    }
    public String getName(){return this.name;}

    public void setCategory_id(Integer category_id){
        this.category_id = category_id;
    }
    public void setName(String name){this.name = name;}
    //endregion
}
