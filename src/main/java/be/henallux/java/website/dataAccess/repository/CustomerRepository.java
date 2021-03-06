package be.henallux.java.website.dataAccess.repository;

import be.henallux.java.website.dataAccess.entity.CustomerEntity;
import be.henallux.java.website.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    CustomerEntity findByUsername(String username);
    CustomerEntity findByUsernameOrEmail(String username, String email);

}
