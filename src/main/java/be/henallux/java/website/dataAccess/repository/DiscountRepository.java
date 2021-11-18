package be.henallux.java.website.dataAccess.repository;

import be.henallux.java.website.dataAccess.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountEntity, Integer> {
}
