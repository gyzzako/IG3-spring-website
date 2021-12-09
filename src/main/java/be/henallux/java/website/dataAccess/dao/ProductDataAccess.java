package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.model.Product;

import java.util.ArrayList;

public interface ProductDataAccess {
    ArrayList<Product> getAllProducts();
    public ArrayList<Product> getAllProductByCategoryId(Integer categoryId);
    Product getProductById(Integer id);
}
