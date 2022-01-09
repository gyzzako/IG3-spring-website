package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.model.ProductEntity;

import java.util.ArrayList;

public interface ProductDataAccess {
    ArrayList<ProductEntity> getAllProducts();
    public ArrayList<ProductEntity> getAllProductByCategoryId(Integer categoryId);
    ProductEntity getProductById(Integer id);
}
