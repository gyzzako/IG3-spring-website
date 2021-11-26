package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.model.OrderLine;

public interface OrderLineDataAccess {
    OrderLine save(OrderLine orderLine);
}
