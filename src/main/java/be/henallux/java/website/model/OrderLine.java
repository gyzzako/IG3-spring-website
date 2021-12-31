package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderLine {
    //region Attribut
    @NotNull
    @Min(value = 1)
    private Integer orderLineId;

    @NotNull
    @Min(value = 1)
    private Float realPrice;

    @NotNull
    @Min(value = 1)
    private Integer quantity;

    private Order order;
    private Product product;
    //endregion



    //region Constructors
    public OrderLine(Integer orderLineId,Float realPrice,Integer quantity,Order order,Product product){
        setOrder(order);
        setOrderLineId(orderLineId);
        setRealPrice(realPrice);
        setProduct(product);
        setQuantity(quantity);
    }

    public OrderLine(){

    }
    //endregion



    //region GETTERS
    public Integer getOrderLineId() {
        return orderLineId;
    }

    public Float getRealPrice() {
        return realPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }
    //endregion


    //region SETTERS
    public void setOrderLineId(Integer orderLineId) {
        this.orderLineId = orderLineId;
    }

    public void setRealPrice(Float realPrice) {
        this.realPrice = realPrice;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    //endregion

}
