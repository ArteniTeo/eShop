package com.example.eShop.controller;

import com.example.eShop.dao.OrderItemDAO;
import com.example.eShop.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

public class OrderItemController {

    @Autowired
    private OrderItemDAO orderItemDAO;

    @RequestMapping(value = "/shopping_cart_product", method = RequestMethod.GET)
    public OrderItem getOIById(@RequestParam(value = "id") int id) throws SQLException {
        return orderItemDAO.findOIById(id);
    }

    @RequestMapping(value = "/shopping_cart_product", method = RequestMethod.POST)
    public OrderItem createOI(@RequestBody OrderItem OI) throws SQLException {
        return orderItemDAO.createOI(OI);
    }

    @RequestMapping(value = "/shopping_cart_product", method = RequestMethod.DELETE)
    public OrderItem deleteOIById(@RequestParam(value = "id") int id) throws SQLException {
        return orderItemDAO.deleteOI(id);
    }

    @RequestMapping(value = "/shopping_cart_product", method = RequestMethod.PUT)
    public OrderItem updateOI(@RequestBody OrderItem OI) throws SQLException {
        return orderItemDAO.updateOI(OI);
    }

}
