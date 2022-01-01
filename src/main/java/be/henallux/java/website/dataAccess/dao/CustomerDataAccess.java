package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.model.Customer;

public interface CustomerDataAccess {
    Customer findByUsername(String username);
    Customer findByUsernameOrEmail(String username, String email);
    Customer save(Customer customer);
}
