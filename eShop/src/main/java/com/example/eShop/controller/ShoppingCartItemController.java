package com.example.eShop.controller;

import com.example.eShop.dao.ShoppingCartItemDAO;
import com.example.eShop.entity.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class ShoppingCartItemController {

    @Autowired
    private ShoppingCartItemDAO shoppingCartItemDAO;

    @RequestMapping(value = "/shopping_cart_item", method = RequestMethod.GET)
    public ShoppingCartItem getSCIById(@RequestParam(value = "id") int id) throws SQLException {
        return shoppingCartItemDAO.findSCIsByCustomerId(id);
    }

    @RequestMapping(value = "/shopping_cart_item", method = RequestMethod.POST)
    public ShoppingCartItem createSCI(@RequestBody ShoppingCartItem SCI) throws SQLException {
        return shoppingCartItemDAO.createSCI(SCI);
    }

    @RequestMapping(value = "/shopping_cart_item", method = RequestMethod.DELETE)
    public ShoppingCartItem deleteSCIById(@RequestParam(value = "id") int id) throws SQLException {
        return shoppingCartItemDAO.deleteSCI(id);
    }

    @RequestMapping(value = "/shopping_cart_item", method = RequestMethod.PUT)
    public ShoppingCartItem updateSCI(@RequestBody ShoppingCartItem SCI) throws SQLException {
        return shoppingCartItemDAO.updateSCI(SCI);
    }
}
