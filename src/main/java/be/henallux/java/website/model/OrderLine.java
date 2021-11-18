package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderLine {
    //region Attribut
    @NotNull
    @Min(value = 1)
    private Integer order_line_id;

    @NotNull
    @Min(value = 1)
    private Float real_price;

    @NotNull
    @Min(value = 1)
    private Integer quantity;

    private Order order;
    private Product product;
    //endregion



    //region Constructors
    public OrderLine(Integer order_line_id,Float real_price,Integer quantity,Order order,Product product){
        setOrder(order);
        setOrder_line_id(order_line_id);
        setReal_price(real_price);
        setProduct(product);
        setQuantity(quantity);
    }

    public OrderLine(){
        this(null, null, null, null, null);
    }
    //endregion



    //region GETTERS
    public Integer getOrder_line_id() {
        return order_line_id;
    }

    public Float getReal_price() {
        return real_price;
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
    public void setOrder_line_id(Integer order_line_id) {
        this.order_line_id = order_line_id;
    }

    public void setReal_price(Float real_price) {
        this.real_price = real_price;
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
