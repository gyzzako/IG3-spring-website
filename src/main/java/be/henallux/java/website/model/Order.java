package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Order {
    //region Attributs
    @NotNull
    @Min(value = 1)
    private Integer orderId;

    @NotNull
    private Date orderDate;

    @NotNull
    private Date deliveryDate;

    @NotNull
    private Boolean isOrderPaid;

    private Customer customer;
    //endregion


    //region Constructors
    public Order(Integer orderId,Date orderDate,Date deliveryDate,Boolean isOrderPaid,Customer customer){
        setCustomer(customer);
        setDeliveryDate(deliveryDate);
        setIsOrderPaid(isOrderPaid);
        setOrderDate(orderDate);
        setOrderId(orderId);
    }

    public Order(){

    }
    //endregion



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

    public Customer getCustomer() {
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

    public void setIsOrderPaid(Boolean isOrderPaid) {
        this.isOrderPaid = isOrderPaid;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    //endregion
}
