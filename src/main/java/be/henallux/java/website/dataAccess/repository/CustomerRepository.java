package be.henallux.java.website.dataAccess.repository;

import be.henallux.java.website.dataAccess.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    //CustomerEntity findByEmailAndPassword(String email, String password);
    CustomerEntity findByEmail(String email);

}
