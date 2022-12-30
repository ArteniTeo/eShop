package com.example.eShop.controller;

import com.example.eShop.dao.ShoppingCartDAO;
import com.example.eShop.entity.ShoppingCart;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class ShoppingCartController {

    @RequestMapping(value = "/shopping_cart", method = RequestMethod.GET)
    public ShoppingCart getSCById(@RequestParam(value = "id") int id) throws SQLException {
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        return shoppingCartDAO.findSCById(id);
    }

    @RequestMapping(value = "/shopping_cart", method = RequestMethod.POST)
    public ShoppingCart createSC(@RequestBody ShoppingCart SC) throws SQLException {
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        return shoppingCartDAO.createSC(SC);
    }

    @RequestMapping(value = "/shopping_cart", method = RequestMethod.DELETE)
    public ShoppingCart deleteSCById(@RequestParam(value = "id") int id) throws SQLException {
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        return shoppingCartDAO.deleteSC(id);
    }

    @RequestMapping(value = "/shopping_cart", method = RequestMethod.PUT)
    public ShoppingCart updateSC(@RequestBody ShoppingCart SC) throws SQLException {
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        return shoppingCartDAO.updateSC(SC);
    }
}
