package com.myMusicStore.DAO.impliment;

import com.myMusicStore.DAO.CartItemDAO;
import com.myMusicStore.Model.Cart;
import com.myMusicStore.Model.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by root on 11/13/16.
 */
@Repository
@Transactional
public class CartItemDAOImpliment implements CartItemDAO{

    @Autowired
    private SessionFactory sessionFactory;


    public void addCartItem(CartItem cartItem) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    public void removeAllCartItems(Cart cart) {

        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem cartItem : cartItems) {
            removeCartItem(cartItem);
        }
    }

    public CartItem getCartItemByProductId(long productId) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where productId = "+productId+"");
        session.flush();

        return (CartItem) query.uniqueResult();
    }

}
