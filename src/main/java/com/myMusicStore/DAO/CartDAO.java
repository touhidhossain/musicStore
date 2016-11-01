package com.myMusicStore.DAO;

import com.myMusicStore.Model.Cart;
import com.myMusicStore.Model.CartItem;

/**
 * Created by root on 10/3/16.
 */
public interface CartDAO {
    Cart getCartById(int cartId);
    void update(Cart cart);
}
