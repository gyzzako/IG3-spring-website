package be.henallux.java.website.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class OrderEntity {
    //region Attributs
    @Id
    @Column(name = "order_id")
    private Integer order_id;

    @Column(name = "order_date")
    private java.util.Date order_date;

    @Column(name = "delivery_date")
    private java.util.Date delivery_date;

    @Column(name = "is_order_paid")
    private Boolean is_order_paid;

    @JoinColumn(name = "customer_fk", referencedColumnName = "customer_id")
    @ManyToOne
    private CustomerEntity customer_fk;
    //endregion

    public OrderEntity(){

    }


    //region GETTERS
    public Integer getOrder_id() {
        return order_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public Boolean getIs_order_paid() {
        return is_order_paid;
    }

    public CustomerEntity getCustomer_fk() {
        return customer_fk;
    }
    //endregion


    //region SETTERS
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public void setIs_order_paid(Boolean is_order_paid) {
        this.is_order_paid = is_order_paid;
    }

    public void setCustomer_fk(CustomerEntity customer_fk) {
        this.customer_fk = customer_fk;
    }
    //endregion
}
