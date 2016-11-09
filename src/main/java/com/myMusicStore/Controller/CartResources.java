package com.myMusicStore.Controller;

import com.myMusicStore.Model.Cart;
import com.myMusicStore.Model.CartItem;
import com.myMusicStore.Model.Customer;
import com.myMusicStore.Model.Product;
import com.myMusicStore.Service.CartService;
import com.myMusicStore.Service.CustomerService;
import com.myMusicStore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by root on 10/23/16.
 */
@Controller
@RequestMapping("/rest/cart")
public class CartResources {
    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/{cartId}")
    public @ResponseBody
    Cart getCartById(@PathVariable(value = "cartId") int cartId){
        return cartService.getCartById(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") long productId, @AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItems();

        for(int i =0; i<cartItems.size(); i++){

        }
    }
}
