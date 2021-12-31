package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Category {

    //region Attributs
    @NotNull
    @Min(value = 1)
    private Integer categoryId;

    //endregion


    //region Constructors
    public Category(Integer categoryId){
        setCategoryId(categoryId);
    }

    public Category(){

    }
    //endregion


    //region GETTERS
    public Integer getCategoryId() {
        return this.categoryId;
    }
    //endregion


    //region SETTERS
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    //endregion
}
