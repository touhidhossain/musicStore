package com.myMusicStore.Service;

import com.myMusicStore.Model.Cart;

/**
 * Created by root on 10/23/16.
 */
public interface CartService {
    Cart getCartById(int cartId);
    void update(Cart cart);
}
