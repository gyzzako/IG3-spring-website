package be.henallux.java.website.model;

import java.util.HashMap;

public class Cart {
    //region Attribut
    private HashMap<Integer, CartItem> products = new HashMap<>(); //key: productId | value: CartItem
    //endregion

    public Cart(){

    }

    public void addProduct(Integer key, CartItem cartItem){
        this.products.put(key, cartItem);
    }
    public HashMap<Integer, CartItem> getProducts(){
        return products;
    }
    public float getTotalPrice(){
        float totalPrice = 0;
        for(CartItem cartItem : this.products.values()){
            totalPrice += cartItem.getSubTotalPrice();
        }
        return totalPrice;
    }
}
