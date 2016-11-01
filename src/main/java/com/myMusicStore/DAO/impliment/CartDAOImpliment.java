package com.myMusicStore.DAO.impliment;

import com.myMusicStore.DAO.CartDAO;
import com.myMusicStore.Model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by root on 10/23/16.
 */
@Repository
@Transactional
public class CartDAOImpliment implements CartDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Cart getCartById(int cartId) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }

    @Override
    public void update(Cart cart) {

    }
}
