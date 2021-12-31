package be.henallux.java.website.services;

import be.henallux.java.website.dataAccess.dao.CustomerDataAccess;
import be.henallux.java.website.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
    private CustomerDataAccess customerDAO;

    @Autowired
    public CustomerService(CustomerDataAccess customerDAO){
        this.customerDAO = customerDAO;
    }
    public boolean saveCustomer(Customer customer){
        Customer customerExistsCheck = customerDAO.findByUsername(customer.getUsername());
        if(customerExistsCheck != null){
            return false;
        }
        customer.setAuthorities("ROLE_USER");
        customer.setCredentialsNonExpired(true);
        customer.setEnabled(true);
        customer.setAccountNonLocked(true);
        customer.setAccountNonExpired(true);
        customerDAO.save(customer);
        return true;
    }
}
