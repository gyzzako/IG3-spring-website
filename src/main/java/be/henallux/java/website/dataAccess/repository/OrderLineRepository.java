package be.henallux.java.website.dataAccess.repository;

import be.henallux.java.website.dataAccess.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity, Integer> {
}
