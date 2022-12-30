package com.example.eShop.controller;

import com.example.eShop.dao.ShoppingCartProductDAO;
import com.example.eShop.entity.ShoppingCartProduct;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

public class ShoppingCartProductController {

    @RequestMapping(value = "/shopping_cart_product", method = RequestMethod.GET)
    public ShoppingCartProduct getSCPById(@RequestParam(value = "id") int id) throws SQLException {
        ShoppingCartProductDAO shoppingCartProductDAO = new ShoppingCartProductDAO();
        return shoppingCartProductDAO.findSCPsById(id);
    }

    @RequestMapping(value = "/shopping_cart_product", method = RequestMethod.POST)
    public ShoppingCartProduct createSCP(@RequestBody ShoppingCartProduct SCP) throws SQLException {
        ShoppingCartProductDAO shoppingCartProductDAO = new ShoppingCartProductDAO();
        return shoppingCartProductDAO.createSCP(SCP);
    }

    @RequestMapping(value = "/shopping_cart_product", method = RequestMethod.DELETE)
    public ShoppingCartProduct deleteSCPById(@RequestParam(value = "id") int id) throws SQLException {
        ShoppingCartProductDAO shoppingCartProductDAO = new ShoppingCartProductDAO();
        return shoppingCartProductDAO.deleteSCP(id);
    }

    @RequestMapping(value = "/shopping_cart_product", method = RequestMethod.PUT)
    public ShoppingCartProduct updateSCP(@RequestBody ShoppingCartProduct SCP) throws SQLException {
        ShoppingCartProductDAO shoppingCartProductDAO = new ShoppingCartProductDAO();
        return shoppingCartProductDAO.updateSCP(SCP);
    }
}