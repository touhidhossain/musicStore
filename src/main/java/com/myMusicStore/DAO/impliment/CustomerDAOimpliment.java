package com.myMusicStore.DAO.impliment;

import com.myMusicStore.DAO.CustomerDAO;
import com.myMusicStore.Model.Authorities;
import com.myMusicStore.Model.Cart;
import com.myMusicStore.Model.Customer;
import com.myMusicStore.Model.Users;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by root on 10/20/16.
 */
@Repository
@Transactional
public class CustomerDAOimpliment implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> getCustomerList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Customer");
        List<Customer> customerList = query.list();
        session.flush();
        return customerList;
    }

    public Customer getCustomerById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.get(Customer.class, id);
        session.flush();
        return customer;
    }

    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Customer WHERE username= '"+username+"' ");
        return (Customer) query.uniqueResult();
    }

    /*@Override
    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.get(Customer.class, username);
        session.flush();
        return customer;
    }*/

    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser = new Users();
        newUser.setCustomerId(customer.getCustomerId());
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);

        Authorities authority = new Authorities();
        authority.setUsername(customer.getUsername());
        authority.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(authority);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);

        customer.setCart(newCart);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public void editCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser = new Users();
        newUser.setCustomerId(customer.getCustomerId());
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);

        Authorities authority = new Authorities();
        authority.setUsername(customer.getUsername());
        authority.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(authority);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);

        customer.setCart(newCart);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public void deleteCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer);
        session.delete(customer.getBillingAddress());
        session.delete(customer.getShippingAddress());

        /*Users newUser = new Users();
        session.delete(newUser.);*/
        session.flush();
    }
}
