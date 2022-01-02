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

    //endregion

    //region GETTERS
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    //endregion
}
