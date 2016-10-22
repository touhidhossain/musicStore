package com.myMusicStore.Service.impliment;

import com.myMusicStore.DAO.CustomerDAO;
import com.myMusicStore.Model.Customer;
import com.myMusicStore.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by root on 10/20/16.
 */
@Service
public class CustomerServiceImpliment implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<Customer> getCustomerList() {
        return customerDAO.getCustomerList();
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerDAO.getCustomerByUsername(username);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    public void editCustomer(Customer customer) {
        customerDAO.editCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerDAO.deleteCustomer(customer);
    }
}
