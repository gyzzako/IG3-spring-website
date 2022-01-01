package be.henallux.java.website.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_line")
public class OrderLineEntity {
    //region Attributs
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "order_line_id")
    private Integer orderLineId;

    @Column(name = "real_price")
    private Float realPrice;

    @Column(name = "quantity")
    private Integer quantity;

    @JoinColumn(name = "order_fk", referencedColumnName = "order_id")
    @ManyToOne
    private OrderEntity order;

    @JoinColumn(name = "product_fk", referencedColumnName = "product_id")
    @ManyToOne
    private ProductEntity product;
    //endregion

    public OrderLineEntity(){

    }

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

    public OrderEntity getOrder() {
        return order;
    }

    public ProductEntity getProduct() {
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

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    //endregion
}
