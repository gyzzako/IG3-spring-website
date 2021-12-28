package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.model.Customer;

public interface CustomerDataAccess {
    //Customer findByEmail(String email);
    Customer findByUsername(String username);
}
