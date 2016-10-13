package com.myMusicStore.Controller;

import com.myMusicStore.Model.Product;
import com.myMusicStore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by root on 10/13/16.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        return "productList";
    }
}
