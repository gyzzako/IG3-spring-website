package be.henallux.java.website.dataAccess.repository;

import be.henallux.java.website.dataAccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    @Modifying
    @Query("UPDATE OrderEntity o set o.isOrderPaid = true where o.orderId = :orderId")
    void setOrderPaid(@Param("orderId") Integer orderId);
}
