package com.myMusicStore.Controller;

import com.myMusicStore.DAO.CartDAO;
import com.myMusicStore.DAO.ProductDAO;
import com.myMusicStore.Model.Cart;
import com.myMusicStore.Model.CartItem;
import com.myMusicStore.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by root on 10/4/16.
 */
@Controller
@RequestMapping("/rest/cart")
public class CartController {
    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable (value = "cartId") String cartId)
    {
        return cartDAO.read(cartId);
    }
    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus (value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable (value = "cartId") String cartId, @RequestBody Cart cart)
    {
        cartDAO.update(cartId, cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable (value = "cartId") String cartId)
    {
       cartDAO.delete(cartId);
    }

    @RequestMapping(value = "/add/{productID}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable (value = "productID") long productID, HttpServletRequest request)
    {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartDAO.read(sessionId);
        if(cart == null)
        {
            cart = cartDAO.create(new Cart(sessionId));
        }
        Product product = productDAO.getProductByID(productID);
        if(product == null)
        {
            throw new IllegalArgumentException(new Exception());
        }
        cart.addCartItem(new CartItem(product));

        cartDAO.update(sessionId, cart);
    }

    @RequestMapping(value = "/remove/{productID}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void  removeItem(@PathVariable long productID, HttpServletRequest request)
    {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartDAO.read(sessionId);
        if(cart == null)
        {
            cart = cartDAO.create(new Cart(sessionId));
        }
        Product product = productDAO.getProductByID(productID);
        if(product == null)
        {
            throw new IllegalArgumentException(new Exception());
        }
        cart.removeCartItem(new CartItem(product));

        cartDAO.update(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus (value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handelClientError(Exception e){}

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus (value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    public void handelServerError(Exception e){}
}
