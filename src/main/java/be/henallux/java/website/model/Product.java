package be.henallux.java.website.model;


import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Objects;

public class Product {


    //region Attributs
    @NotNull
    @Min(value = 1)
    private Integer productId;

    @NotNull
    @Size(min = 5, max = 50)
    private String productName;

    @NotNull
    @Size(min = 10, max = 200)
    private String description;

    @NotNull
    @Size(min = 5, max = 60)
    private String brand;

    private Discount discount;

    @NotNull
    private Category category;

    @NotNull
    @Min(value = 0)
    private Float price;

    private Float priceAfterDiscountCalculation;

    @NotNull
    private String imageName;
    //endregion


    //region Constructors
    public Product(Integer productId, String productName, String description, String brand, Discount discount, Category category, Float price, Float priceAfterDiscountCalculation){
        setProductId(productId);
        setProductName(productName);
        setDescription(description);
        setBrand(brand);
        setDiscount(discount);
        setCategory(category);
        setPrice(price);
        setPriceAfterDiscountCalculation(priceAfterDiscountCalculation);
    }

    public Product(){
    }
    //endregion


    //region GETTERS
    public Integer getProductId(){
        return this.productId;
    }
    public String getProductName(){
        return this.productName;
    }
    public String getDescription(){
        return this.description;
    }
    public String getBrand(){
        return this.brand;
    }
    public Discount getDiscount(){
        return this.discount;
    }
    public Category getCategory(){
        return this.category;
    }
    public Float getPrice(){
        return this.price;
    }
    public Float getPriceAfterDiscountCalculation(){
        return this.priceAfterDiscountCalculation;
    }
    public boolean isOnDiscount(){
        return !this.price.equals(this.priceAfterDiscountCalculation);
    }
    public String getImageName() {
        return imageName;
    }
    //endregion


    //region SETTERS
    public void setProductId(Integer productId){
        this.productId = productId;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setDiscount(Discount discount){
        this.discount = discount;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    public void setPrice(Float price){
        //String priceFormated = decimalFormat.format(this.price);
        //price = Float.parseFloat(priceFormated);
        this.price= price;
    }
    public void setPriceAfterDiscountCalculation(Float priceAfterDiscountCalculation){
        this.priceAfterDiscountCalculation = priceAfterDiscountCalculation;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    //endregion
}
