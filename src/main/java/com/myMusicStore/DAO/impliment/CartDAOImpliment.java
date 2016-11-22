package com.myMusicStore.DAO.impliment;

import com.myMusicStore.DAO.CartDAO;
import com.myMusicStore.Model.Cart;
import com.myMusicStore.Service.CustomerOrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Created by root on 10/23/16.
 */
@Repository
@Transactional
public class CartDAOImpliment implements CartDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CustomerOrderService customerOrderService;


    public Cart getCartById(int cartId) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }

    public void update(Cart cart) {
        int cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
        session.flush();
    }

    public Cart validate(int cartId) throws IOException{
        Cart cart = getCartById(cartId);

        if(cart == null || cart.getCartItems().size()==0){
            throw new IOException(cartId+"");
        }

        update(cart);

        return cart;
    }
}
