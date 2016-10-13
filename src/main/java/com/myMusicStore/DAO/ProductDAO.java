package com.myMusicStore.DAO;

import com.myMusicStore.Model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TOUHID on 7/9/2016.
 */
public interface ProductDAO {
    List<Product> getProductList();
    Product getProductById(long id);
    void addProduct(Product product);
    void editProduct(Product product);
    void deleteProduct(Product product);
}
