package com.myMusicStore.Controller;

import com.myMusicStore.Model.Product;
import com.myMusicStore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
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

    @RequestMapping("/viewProduct/{id}")
    public String getProducts(Model model, @PathVariable("id") long id) throws IOException {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "viewProduct";
    }
}
