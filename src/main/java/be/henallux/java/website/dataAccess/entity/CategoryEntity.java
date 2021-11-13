package be.henallux.java.website.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @Column(name = "category_id")
    private Integer category_id;

    //---Getter
    public Integer getCategory_id(Integer category_id){
        return this.category_id = category_id;
    }
    //--Setter
    public void setCategory_id(Integer category_id){
        this.category_id = category_id;
    }

}
