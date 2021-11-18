package be.henallux.java.website.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_line")
public class OrderLineEntity {
    //region Attributs
    @Id
    @Column(name = "order_line_id")
    private Integer order_line_id;

    @Column(name = "real_price")
    private Float real_price;

    @Column(name = "quantity")
    private Integer quantity;

    @JoinColumn(name = "order_fk", referencedColumnName = "order_id")
    @ManyToOne
    private OrderEntity order_fk;

    @JoinColumn(name = "product_fk", referencedColumnName = "product_id")
    @ManyToOne
    private ProductEntity product_fk;
    //endregion

    public OrderLineEntity(){

    }

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

    public OrderEntity getOrder_fk() {
        return order_fk;
    }

    public ProductEntity getProduct_fk() {
        return product_fk;
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

    public void setOrder_fk(OrderEntity order_fk) {
        this.order_fk = order_fk;
    }

    public void setProduct_fk(ProductEntity product_fk) {
        this.product_fk = product_fk;
    }
    //endregion
}
