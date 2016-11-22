package com.myMusicStore.DAO.impliment;

import com.myMusicStore.DAO.CustomerOrderDAO;
import com.myMusicStore.Model.CustomerOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by root on 11/19/16.
 */
@Repository
@Transactional
public class CustomerOrderDAOImpliment implements CustomerOrderDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }
}
