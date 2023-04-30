package com.example.eShop.controller;

import com.example.eShop.dao.ProductDAO;
import com.example.eShop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Product getProductById(@RequestParam(value = "id") int id) throws SQLException {
        return productDAO.findProductById(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) throws SQLException {
        return productDAO.createProduct(product);
    }

    @RequestMapping(value = "/product", method = RequestMethod.DELETE)
    public Product deleteProductById(@RequestParam(value = "id") int id) throws SQLException {
        return productDAO.deleteProduct(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) throws SQLException {
        return productDAO.updateProduct(product);
    }

}
