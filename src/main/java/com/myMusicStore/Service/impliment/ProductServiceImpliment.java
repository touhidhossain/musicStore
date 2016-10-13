package com.myMusicStore.Service.impliment;

import com.myMusicStore.DAO.ProductDAO;
import com.myMusicStore.Model.Product;
import com.myMusicStore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by root on 10/13/16.
 */
@Service
public class ProductServiceImpliment implements ProductService{
    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> getProductList() {
        return productDAO.getProductList();
    }

    @Override
    public Product getProductById(long productId) {
        return productDAO.getProductById(productId);
    }

    @Override
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Override
    public void editProduct(Product product) {
        productDAO.editProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productDAO.deleteProduct(product);
    }
}
