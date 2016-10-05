package com.myMusicStore.Controller;

import com.myMusicStore.DAO.ProductDAO;
import com.myMusicStore.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by root on 9/28/16.
 */
@Controller
public class AdminController {

    private Path path;

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/admin")
    public String adminPage()
    {
        return "admin";
    }
    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model)
    {
        List<Product> productList = productDAO.getAllProduct();
        model.addAttribute("products",productList);

        return  "productInventory";
    }
    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model)
    {
        Product product = new Product();
        model.addAttribute("product",product);

        return  "addProduct";
    }
    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request)
    {
        if(result.hasErrors())
        {
            return "addProduct";
        }
        productDAO.addProduct(product);
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "WEB-INF/resources/images/" +product.getProductID()+".png");

        if(productImage != null && !productImage.isEmpty())
        {
            try {
                productImage.transferTo(new File(path.toString()));
            }
            catch (Exception e)
            {
                e.printStackTrace();
                throw new RuntimeException("Product Image Saving Failed", e);
            }
        }
        return  "redirect:/admin/productInventory";
    }
    @RequestMapping("/admin/productInventory/deleteProduct/{productID}")
    public String deleteProduct(@PathVariable long productID, HttpServletRequest request) throws IOException
    {
        productDAO.deleteProduct(productID);
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "WEB-INF/resources/images/" +productID+".png");

        if(Files.exists(path))
        {
            try {
                Files.delete(path);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                throw new RuntimeException("Product Image Deleting Failed", e);
            }
        }
        return  "redirect:/admin/productInventory";
    }
    @RequestMapping(value = "/admin/productInventory/editProduct/{productID}")
    public String editProduct(@PathVariable long productID, Model model) throws IOException
    {
        Product product = productDAO.getProductByID(productID);
        model.addAttribute(product);
        return "editProduct";
    }
    @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request)
    {
        if(result.hasErrors())
        {
            return "editProduct";
        }
        productDAO.editProduct(product);
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "WEB-INF/resources/images/" +product.getProductID()+".png");

        if(productImage != null && !productImage.isEmpty())
        {
            try {
                productImage.transferTo(new File(path.toString()));
            }
            catch (Exception e)
            {
                e.printStackTrace();
                throw new RuntimeException("Product Image Edit Failed", e);
            }
        }
        return  "redirect:/admin/productInventory";
    }
}
