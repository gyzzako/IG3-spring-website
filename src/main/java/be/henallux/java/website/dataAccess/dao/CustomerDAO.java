package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.dataAccess.entity.CustomerEntity;
import be.henallux.java.website.dataAccess.repository.CustomerRepository;
import be.henallux.java.website.dataAccess.utils.ProviderConverter;
import be.henallux.java.website.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDAO implements CustomerDataAccess{
    private CustomerRepository customerRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CustomerDAO(CustomerRepository customerRepository, ProviderConverter providerConverter){
        this.customerRepository = customerRepository;
        this.providerConverter = providerConverter;
    }


    @Override
    public Customer findByUsername(String username) {
        CustomerEntity customerEntity = customerRepository.findByUsername(username);
        if(customerEntity == null)
            return null;
        // juste pour tester qu'on renvoie bien les identifiants de l'utilisateur de la bd.
        System.out.println(customerEntity.getUsername());
        System.out.println(customerEntity.getPassword());
        return providerConverter.customerEntityToCustomerModel(customerEntity);
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = providerConverter.customerModelToCustomerEntity(customer);
        customerEntity = customerRepository.save(customerEntity);
        return providerConverter.customerEntityToCustomerModel(customerEntity);
    }
}
