package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.dataAccess.entity.OrderLineEntity;
import be.henallux.java.website.model.OrderLine;

import java.util.ArrayList;
import java.util.List;

public interface OrderLineDataAccess {
    OrderLine save(OrderLine orderLine);
    List<OrderLineEntity> saveAll(ArrayList<OrderLine> orderLines);
}
