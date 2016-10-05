package com.myMusicStore.Model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Created by TOUHID on 7/9/2016.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long productID;

    @NotEmpty (message = "Product name must not be null.")
    private String productName;
    private  String productCategory;
    private  String productDescription;

    @Min(value = 0, message = "Product price must not be less than zero")
    private double productPrice;
    private String productCondition;
    private  String productStatus;
    @Min(value = 0, message = "Product unit must not be less than zero")
    private int unitInStock;
    private String productManufacture;

    @Transient
    private MultipartFile productImage;

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductManufacture() {
        return productManufacture;
    }

    public void setProductManufacture(String productManufacture) {
        this.productManufacture = productManufacture;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }
}
