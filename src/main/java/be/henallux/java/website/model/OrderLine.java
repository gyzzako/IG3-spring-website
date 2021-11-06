package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderLine {

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

    public OrderLine(Integer order_line_id,Float real_price,Integer quantity,Order order,Product product){
        this.order = order;
        this.order_line_id = order_line_id;
        this.real_price = real_price;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderLine(){}

    public Integer getOrder_line_id() {
        return order_line_id;
    }

    public void setOrder_line_id(Integer order_line_id) {
        this.order_line_id = order_line_id;
    }

    public Float getReal_price() {
        return real_price;
    }

    public void setReal_price(Float real_price) {
        this.real_price = real_price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
