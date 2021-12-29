package be.henallux.java.website.services;

import be.henallux.java.website.dataAccess.dao.CustomerDAO;
import be.henallux.java.website.dataAccess.dao.CustomerDataAccess;
import be.henallux.java.website.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsServiceImplementation implements UserDetailsService {

    private CustomerDataAccess customerDAO;

    @Autowired
    public CustomerDetailsServiceImplementation(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerDAO.findByUsername(username);
        if(customer != null){
            System.out.println("----------DAO----------------"); //juste pour tester.
            System.out.println("Username dao :"+customer.getUsername());
            System.out.println("customer dao password :"+customer.getPassword());
            return customer;
        }
        throw new UsernameNotFoundException("Customer not found bicth !");
    }
}
