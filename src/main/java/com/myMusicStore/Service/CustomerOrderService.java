package com.myMusicStore.Service;

import com.myMusicStore.Model.CustomerOrder;

/**
 * Created by root on 11/19/16.
 */
public interface CustomerOrderService {
    void addCustomerOrder(CustomerOrder customerOrder);
    double getCustomerOrderGrandTotal(int cartId);
}
