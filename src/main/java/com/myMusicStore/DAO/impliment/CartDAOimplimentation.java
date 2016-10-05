package com.myMusicStore.DAO.impliment;

import com.myMusicStore.DAO.CartDAO;
import com.myMusicStore.Model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 10/3/16.
 */
@Repository
public class CartDAOimplimentation implements CartDAO {

    private Map<String, Cart> listOfCarts;

    public CartDAOimplimentation()
    {
        listOfCarts = new HashMap<String, Cart>();
    }

    public Cart create(Cart cart) {
        if(listOfCarts.keySet().contains(cart.getCartId()))
        {
            throw new IllegalArgumentException(String.format("Can not create a cart. A cart with the given id(%) already exist.", cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(), cart);

        return cart;
    }

    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    public void update(String cartId, Cart cart) {
        if(!listOfCarts.keySet().contains(cartId))
        {
            throw new IllegalArgumentException(String.format("Can not update a cart. A cart with the given id(%) does not exist.", cart.getCartId()));
        }

        listOfCarts.put(cartId, cart);
    }

    public void delete(String cartId) {
        if(!listOfCarts.keySet().contains(cartId))
        {
            throw new IllegalArgumentException(String.format("Can not update a cart. A cart with the given id(%) does not exist.", cartId));
        }

        listOfCarts.remove(cartId);
    }
}
