package com.myMusicStore.DAO;

import com.myMusicStore.Model.Customer;
import com.myMusicStore.Model.Product;

import java.util.List;

/**
 * Created by root on 10/20/16.
 */
public interface CustomerDAO {
    List<Customer> getCustomerList();
    Customer getCustomerById(long id);
    Customer getCustomerByUsername(String username);
    void addCustomer(Customer customer);
    void editCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
