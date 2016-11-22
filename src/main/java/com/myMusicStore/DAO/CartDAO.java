package com.myMusicStore.DAO;

import com.myMusicStore.Model.Cart;
import com.myMusicStore.Model.CartItem;

import java.io.IOException;

/**
 * Created by root on 10/3/16.
 */
public interface CartDAO {
    Cart getCartById(int cartId);
    Cart validate(int cartId) throws IOException;
    void update(Cart cart);
}
