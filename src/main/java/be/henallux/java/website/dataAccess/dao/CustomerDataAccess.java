package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.model.Customer;

public interface CustomerDataAccess {
    Customer findByUsername(String username);
    Customer save(Customer customer);
}
