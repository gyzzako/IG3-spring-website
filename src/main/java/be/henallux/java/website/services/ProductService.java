package be.henallux.java.website.services;

import be.henallux.java.website.dataAccess.dao.ProductDataAccess;
import be.henallux.java.website.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ProductService {
    private ProductDataAccess productDAO;

    @Autowired
    public ProductService(ProductDataAccess productDAO){
        this.productDAO = productDAO;
    }

    public ProductEntity getProductById(Integer id){
        return productDAO.getProductById(id);
    }

    public ArrayList<ProductEntity> getAllProductByCategoryId(Integer id){
        return productDAO.getAllProductByCategoryId(id);
    }
}
