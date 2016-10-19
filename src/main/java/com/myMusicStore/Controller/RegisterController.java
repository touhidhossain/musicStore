package com.myMusicStore.Controller;

import com.myMusicStore.Model.BillingAddress;
import com.myMusicStore.Model.Customer;
import com.myMusicStore.Model.ShippingAddress;
import com.myMusicStore.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by root on 10/19/16.
 */
@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value ="/register", method = RequestMethod.GET)
    public String registerCustomer(Model model){
        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();

        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer", customer);

        return "registerCustomer";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCudtomerPosr(@Valid @ModelAttribute("customer") Customer customer,
                                       BindingResult result, HttpServletRequest request){
        if(result.hasErrors()){
            return "registerCustomer";
        }
        customerService.addCustomer(customer);

        return "registerCustomerSuccess";
    }
}
