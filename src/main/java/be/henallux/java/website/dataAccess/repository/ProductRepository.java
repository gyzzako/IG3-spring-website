package be.henallux.java.website.dataAccess.repository;

import be.henallux.java.website.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Query("SELECT product FROM ProductEntity product WHERE product.category_fk.category_id = ?1")
    ArrayList<ProductEntity> findByCategory_fkCategory_id(Integer categoryId);
}
