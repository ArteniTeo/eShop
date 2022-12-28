package com.example.eShop.controller;

import com.example.eShop.dao.ProductDAO;
import com.example.eShop.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class ProductController {

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Product getProductById(@RequestParam(value = "id") int id) throws SQLException {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.findProductById(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) throws SQLException {
        ProductDAO productDAO = new ProductDAO();

        return productDAO.createProduct(product);
    }

    @RequestMapping(value = "/product", method = RequestMethod.DELETE)
    public Product deleteProductById(@RequestParam(value = "id") int id) throws SQLException {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.deleteProduct(id);
    }

}
