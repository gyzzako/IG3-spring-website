package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.model.Category;

import java.util.ArrayList;

public interface CategoryDataAccess {
    ArrayList<Category> getAllCategories();
}
