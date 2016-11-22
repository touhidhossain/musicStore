package com.myMusicStore.Service.impliment;

import com.myMusicStore.DAO.CustomerOrderDAO;
import com.myMusicStore.Model.Cart;
import com.myMusicStore.Model.CartItem;
import com.myMusicStore.Model.CustomerOrder;
import com.myMusicStore.Service.CartService;
import com.myMusicStore.Service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by root on 11/19/16.
 */
@Service
public class CustomerOrderServiceImpliment implements CustomerOrderService{
    @Autowired
    private CustomerOrderDAO customerOrderDAO;

    @Autowired
    private CartService cartService;
    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDAO.addCustomerOrder(customerOrder);
    }

    @Override
    public double getCustomerOrderGrandTotal(int cartId) {
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for(CartItem item : cartItems){
            grandTotal += item.getTotalPrice();
        }

        return grandTotal;
    }
}
