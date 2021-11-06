package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {

    @NotNull
    @Min(value = 1)
    private Integer product_id;

    @NotNull
    @Size(min = 5, max = 50)
    private String product_name;

    @NotNull
    @Size(min = 10, max = 200)
    private String description;

    @NotNull
    @Size(min = 5, max = 60)
    private String brand;
    private Discount discount_fk;

    @NotNull
    private Category category_fk;

    @NotNull
    @Min(value = 1)
    private Float price;

    public Product(Integer product_id, String product_name, String description, String brand, Discount discount_fk, Category category_fk, Float price){
        this.brand = brand;
        this.product_name = product_name;
        this.description = description;
        this.category_fk = category_fk;
        this.product_id = product_id;
        this.price = price;
    }

    public Product(){}

    //---------Getters------------
    public Integer getProduct_id(){
        return this.product_id;
    }
    public String getProduct_name(){
        return this.product_name;
    }
    public String getDescription(){
        return this.description;
    }
    public String getBrand(){
        return this.brand;
    }
    public Discount getDiscount_fk(){
        return this.discount_fk;
    }
    public Category getCategory_fk(){
        return this.category_fk;
    }
    public Float getPrice(){
        return this.price;
    }

    //----------------Setters-------------------
    public void setProduct_id(Integer product_id){
        this.product_id = product_id;
    }
    public void setProduct_name(String product_name){
        this.product_name = product_name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setDiscount_fk(Discount discount_fk){
        this.discount_fk = discount_fk;
    }
    public void setCategory_fk(Category category_fk){
        this.category_fk = category_fk;
    }
    public void setPrice(Float price){
        this.price= price;
    }
}
