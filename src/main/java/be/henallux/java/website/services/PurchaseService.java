package be.henallux.java.website.services;

import be.henallux.java.website.dataAccess.dao.OrderDataAccess;
import be.henallux.java.website.dataAccess.dao.OrderLineDataAccess;
import be.henallux.java.website.model.Customer;
import be.henallux.java.website.model.Order;
import be.henallux.java.website.model.OrderLine;
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

    @Autowired
    public PurchaseService(OrderLineDataAccess orderLineDAO, OrderDataAccess orderDAO){
        this.orderDAO = orderDAO;
        this.orderLineDAO = orderLineDAO;
    }

    public Order savePurchase(HashMap<Integer, OrderLine> products, Customer customer){
        Instant now = Instant.now(); //current date
        Instant deliveryDate = now.plus(Duration.ofDays(deliveryDayTime));

        Order order = new Order(null,new Date(), Date.from(deliveryDate), false, customer);
        Order orderFromDB = orderDAO.save(order);

        ArrayList<OrderLine> orderLines = new ArrayList<>();
        for(OrderLine orderLine : products.values()){
            orderLine.setOrder(orderFromDB);
            orderLines.add(orderLine);
        }
        orderLineDAO.saveAll(orderLines);

        return orderFromDB;
    }

    public void modifyOrderToPaid(Integer orderId){
        orderDAO.setOrderPaid(orderId);
    }
}