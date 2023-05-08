package com.example.eShop.controller;

import com.example.eShop.dao.OrderItemDAO;
import com.example.eShop.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class OrderItemController {

    @Autowired
    private OrderItemDAO orderItemDAO;

    @RequestMapping(value = "/order_items", method = RequestMethod.GET)
    public List<OrderItem> getOIById(@RequestParam(value = "orderId") int id) throws SQLException {
        return orderItemDAO.findOIById(id);
    }

    @RequestMapping(value = "/order_item", method = RequestMethod.POST)
    public OrderItem createOI(@RequestBody OrderItem OI) throws SQLException {
        return orderItemDAO.createOI(OI);
    }

    @RequestMapping(value = "/order_item", method = RequestMethod.DELETE)
    public OrderItem deleteOIById(@RequestParam(value = "id") int id) throws SQLException {
        return orderItemDAO.deleteOI(id);
    }

    @RequestMapping(value = "/order_item", method = RequestMethod.PUT)
    public OrderItem updateOI(@RequestBody OrderItem OI) throws SQLException {
        return orderItemDAO.updateOI(OI);
    }

}
