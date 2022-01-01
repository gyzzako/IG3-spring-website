package be.henallux.java.website.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "`order`")
public class OrderEntity {
    //region Attributs
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "is_order_paid")
    private Boolean isOrderPaid;

    @JoinColumn(name = "customer_fk", referencedColumnName = "customer_id")
    @ManyToOne
    private CustomerEntity customer;
    //endregion

    public OrderEntity(){

    }


    //region GETTERS

    public Integer getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public Boolean getIsOrderPaid() {
        return isOrderPaid;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    //endregion


    //region SETTERS

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setIsOrderPaid(Boolean orderPaid) {
        isOrderPaid = orderPaid;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    //endregion
}
