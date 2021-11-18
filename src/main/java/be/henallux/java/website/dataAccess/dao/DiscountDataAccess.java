package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.model.Discount;

public interface DiscountDataAccess {
    Discount getDiscount(Integer id);
}
