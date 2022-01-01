package be.henallux.java.website.services;

import be.henallux.java.website.dataAccess.dao.OrderDataAccess;
import be.henallux.java.website.dataAccess.dao.OrderLineDataAccess;
import be.henallux.java.website.dataAccess.dao.ProductDataAccess;
import be.henallux.java.website.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Service
public class PurchaseService {
    private final Integer deliveryDayTime = 5;
    private OrderLineDataAccess orderLineDAO;
    private OrderDataAccess orderDAO;
    private ProductDataAccess productDAO;

    @Autowired
    public PurchaseService(OrderLineDataAccess orderLineDAO, OrderDataAccess orderDAO, ProductDataAccess productDAO){
        this.orderDAO = orderDAO;
        this.orderLineDAO = orderLineDAO;
        this.productDAO = productDAO;
    }

    public Order savePurchase(HashMap<Integer, CartItem> products, Customer customer){
        Instant now = Instant.now(); //current date
        Instant deliveryDate = now.plus(Duration.ofDays(deliveryDayTime));

        Order order = new Order(null,new Date(), Date.from(deliveryDate), false, customer);
        Order orderFromDB = orderDAO.save(order);

        ArrayList<OrderLine> orderLines = new ArrayList<>();
        for(CartItem cartItem : products.values()){
            Product product = productDAO.getProductById(cartItem.getProductId());
            OrderLine orderLine = new OrderLine(null, cartItem.getPrice(), cartItem.getQuantity(), orderFromDB, product);
            orderLines.add(orderLine);
        }
        orderLineDAO.saveAll(orderLines);

        return orderFromDB;
    }

    public void modifyOrderToPaid(Integer orderId){
        orderDAO.setOrderPaid(orderId);
    }
}