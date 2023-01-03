package com.example.eShop.controller;

import com.example.eShop.dao.ShoppingCartItemDAO;
import com.example.eShop.entity.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

public class ShoppingCartItemController {

    @Autowired
    private ShoppingCartItemDAO shoppingCartItemDAO;

    @RequestMapping(value = "/shopping_cart_product", method = RequestMethod.GET)
    public ShoppingCartItem getSCIById(@RequestParam(value = "id") int id) throws SQLException {
        return shoppingCartItemDAO.findSCIsById(id);
    }

    @RequestMapping(value = "/shopping_cart_product", method = RequestMethod.POST)
    public ShoppingCartItem createSCI(@RequestBody ShoppingCartItem SCI) throws SQLException {
        return shoppingCartItemDAO.createSCI(SCI);
    }

    @RequestMapping(value = "/shopping_cart_product", method = RequestMethod.DELETE)
    public ShoppingCartItem deleteSCIById(@RequestParam(value = "id") int id) throws SQLException {
        return shoppingCartItemDAO.deleteSCI(id);
    }

    @RequestMapping(value = "/shopping_cart_product", method = RequestMethod.PUT)
    public ShoppingCartItem updateSCI(@RequestBody ShoppingCartItem SCI) throws SQLException {
        return shoppingCartItemDAO.updateSCI(SCI);
    }
}
