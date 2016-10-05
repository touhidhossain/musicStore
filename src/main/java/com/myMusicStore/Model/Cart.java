package com.myMusicStore.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 10/3/16.
 */
public class Cart {
    private String cartId;
    private Map<Long, CartItem> cartItems;
    private double grandTotal;

    private Cart()
    {
        cartItems = new HashMap<Long, CartItem>();
        grandTotal = 0;
    }
    public Cart(String cartId)
    {
        this();
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<Long, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Long, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void addCartItem(CartItem item){
        long productId = item.getProduct().getProductID();
        if(cartItems.containsKey(productId))
        {
            CartItem existingCartItem = cartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity()+item.getQuantity());
            cartItems.put(productId, existingCartItem);
        } else {
            cartItems.put(productId,item);
        }

        updateGrandTotal();
    }

    public void removeCartItem(CartItem item){
        long productId = item.getProduct().getProductID();
        cartItems.remove(productId);
        updateGrandTotal();
    }

    public void updateGrandTotal(){
        grandTotal = 0;
        for(CartItem item : cartItems.values())
        {
            grandTotal = grandTotal + item.getTotalPrice();
        }
    }
}
