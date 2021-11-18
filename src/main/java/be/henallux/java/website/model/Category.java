package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Category {

    //region Attributs
    @NotNull
    @Min(value = 1)
    private Integer category_id;
    //endregion


    //region Constructors
    public Category(Integer category_id){
        setCategory_id(category_id);
    }

    public Category(){
        this(null);
    }
    //endregion


    //region GETTERS
    public Integer getCategory_id() {
        return category_id;
    }
    //endregion


    //region SETTERS
    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
    //endregion
}
