package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Order {


    @NotNull
    @Min(value = 1)
    private Integer order_id;

    @NotNull
    private Date order_date;

    @NotNull
    private Date delivery_date;

    @NotNull
    private Boolean is_order_paid;

    private Customer customer;

    public Order(Integer order_id,Date order_date,Date delivery_date,Boolean is_order_paid,Customer customer){
        this.customer = customer;
        this.delivery_date = delivery_date;
        this.is_order_paid = is_order_paid;
        this.order_id = order_id;
        this.order_date = order_date;
    }

    public Order(){}

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public Boolean getIs_order_paid() {
        return is_order_paid;
    }

    public void setIs_order_paid(Boolean is_order_paid) {
        this.is_order_paid = is_order_paid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
