package com.myMusicStore.DAO.impliment;

import com.myMusicStore.DAO.CustomerDAO;
import com.myMusicStore.Model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

    @Override
    public List<Customer> getCustomerList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Customer");
        List<Customer> customerList = query.list();
        session.flush();
        return customerList;
    }

    @Override
    public Customer getCustomerById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.get(Customer.class, id);
        session.flush();
        return customer;
    }

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
        session.flush();
    }

    @Override
    public void editCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
        session.flush();
    }

    @Override
    public void deleteCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer);
        session.flush();
    }
}
