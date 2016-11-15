package com.myMusicStore.Service.impliment;

import com.myMusicStore.DAO.CartItemDAO;
import com.myMusicStore.Model.Cart;
import com.myMusicStore.Model.CartItem;
import com.myMusicStore.Service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by root on 11/13/16.
 */
@Service
public class CartItemServiceImpliment implements CartItemService{
    @Autowired
    private CartItemDAO cartItemDAO;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemDAO.removeCartItem(cartItem);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        cartItemDAO.removeAllCartItems(cart);
    }

    @Override
    public CartItem getCartItemByProductId(long productId) {
        return cartItemDAO.getCartItemByProductId(productId);
    }
}
