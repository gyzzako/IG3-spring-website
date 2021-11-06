package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Category {

    @NotNull
    @Min(value = 1)
    private Integer category_id;

    public Category(Integer category_id){
        this.category_id = category_id;
    }

    public Category(){}
}
