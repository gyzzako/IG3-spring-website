package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.model.Customer;

public interface CustomerDataAccess {
    Customer getCustomer(String email, String password);
}
