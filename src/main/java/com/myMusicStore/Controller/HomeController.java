package com.myMusicStore.Controller;

import com.myMusicStore.DAO.ProductDAO;
import com.myMusicStore.Model.Product;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
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
 * Created by TOUHID on 7/9/2016.
 */
@Controller
public class HomeController {

    @Autowired
    private ProductDAO productDAO;
    @RequestMapping("/")
    public String home()
    {
       return "home";
    }
    @RequestMapping("/productList")
    public String productList(Model model)
    {
        List<Product> productList = productDAO.getAllProduct();
        model.addAttribute("products",productList);
        return "productList";
    }
    @RequestMapping("/productList/viewProduct/{productID}")
    public String viewProduct(@PathVariable long productID, Model model) throws IOException
    {
        Product product = productDAO.getProductByID(productID);
        model.addAttribute(product);
        return "viewProduct";
    }

}