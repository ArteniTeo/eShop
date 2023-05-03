package com.example.eShop.controller;

import com.example.eShop.dao.ShoppingCartItemDAO;
import com.example.eShop.entity.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class ShoppingCartItemController {

    @Autowired
    private ShoppingCartItemDAO shoppingCartItemDAO;

    @RequestMapping(value = "/shopping_cart_item", method = RequestMethod.GET)
    public List<ShoppingCartItem> getSCIById(@RequestParam(value = "id") int id) throws SQLException {
        return shoppingCartItemDAO.findSCIsByCustomerId(id);
    }

    @RequestMapping(value = "/shopping_cart_item", method = RequestMethod.POST)
    public ShoppingCartItem createSCI(@RequestParam(value = "productId") int productId,
                                      @RequestParam(value = "customerId") int customerId,
                                      @RequestParam(value = "qty") int qty) throws SQLException {
        return shoppingCartItemDAO.createSCI(productId, customerId, qty);
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
