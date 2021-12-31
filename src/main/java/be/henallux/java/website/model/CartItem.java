package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CartItem {
    //region Attribut
    @NotNull
    @Min(value = 1)
    private Integer quantity;

    @NotNull
    @Min(value = 1)
    private Integer productId;

    @Min(value = 1)
    private Float price;

    private String name;

    private String imageName;
    //endregion

    public CartItem() {
    }

    //region GETTERS
    public Integer getQuantity() {
        return quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getImageName() {
        return imageName;
    }

    public Float getPrice() {
        return price;
    }

    //endregion

    //region GETTERS
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public float getSubTotalPrice(){
        return this.price * this.quantity;
    }
    //endregion
}
