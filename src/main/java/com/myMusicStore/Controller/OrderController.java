package com.myMusicStore.Controller;

import com.myMusicStore.Model.Cart;
import com.myMusicStore.Model.Customer;
import com.myMusicStore.Model.CustomerOrder;
import com.myMusicStore.Service.CartService;
import com.myMusicStore.Service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by root on 11/19/16.
 */
@Controller
public class OrderController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;
    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId){
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cartId);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());

        customerOrderService.addCustomerOrder(customerOrder);

        return "redirect:/checkout?cartId="+cartId;
    }
}
