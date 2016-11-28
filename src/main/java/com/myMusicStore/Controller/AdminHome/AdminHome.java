package com.myMusicStore.Controller.AdminHome;

import com.myMusicStore.Model.Customer;
import com.myMusicStore.Model.Product;
import com.myMusicStore.Service.CustomerService;
import com.myMusicStore.Service.ProductService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by root on 10/14/16.
 */
@Controller
@RequestMapping("/admin")
public class AdminHome {
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productList(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productInventory";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model){
        List<Customer> customerList = customerService.getCustomerList();
        model.addAttribute("customerList", customerList);
        return "customerManagement";
    }

    @RequestMapping("/customer/editCustomer/{customerId}")
    public String customerManagement(@PathVariable("customerId") long customerId, Model model){
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, customerId);
        model.addAttribute("customer", customer);
        return "editCustomer";
    }
}
