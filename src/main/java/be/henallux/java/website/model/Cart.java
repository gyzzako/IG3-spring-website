package be.henallux.java.website.model;

import java.util.HashMap;

public class Cart {
    //region Attribut
    private HashMap<Integer, OrderLine> products = new HashMap<>(); //key: productId | value: OrderLine
    //endregion

    public Cart(){

    }

    public void addProduct(Integer key, OrderLine orderLine){
        this.products.put(key, orderLine);
    }
    public HashMap<Integer, OrderLine> getProducts(){
        return products;
    }
    public float getTotalPrice(){
        float totalPrice = 0;
        for(OrderLine orderLine : this.products.values()){
            totalPrice += orderLine.getSubTotalPrice();
        }
        return totalPrice;
    }
}
