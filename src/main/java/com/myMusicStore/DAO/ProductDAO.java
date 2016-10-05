package com.myMusicStore.DAO;

import com.myMusicStore.Model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TOUHID on 7/9/2016.
 */
public interface ProductDAO {
    void addProduct(Product product);
    void editProduct(Product product);
    Product getProductByID(long id);
    List<Product> getAllProduct();
    void deleteProduct(long id);
}
