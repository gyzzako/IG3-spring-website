package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.model.Product;

import java.util.ArrayList;

public interface ProductDataAccess {
    ArrayList<Product> getAllProducts();
    ArrayList<Product> getAllProductByCategory(String categoryName);
    Product getProductById(Integer id);
}
