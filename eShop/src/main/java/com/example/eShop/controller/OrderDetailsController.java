package com.example.eShop.controller;

import com.example.eShop.dao.OrderDetailsDAO;
import com.example.eShop.entity.OrderDetails;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class OrderDetailsController {

    @RequestMapping(value = "/order_details", method = RequestMethod.GET)
    public OrderDetails getODById(@RequestParam(value = "id") int id) throws SQLException {
        OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
        return orderDetailsDAO.findODById(id);
    }

    @RequestMapping(value = "/order_details", method = RequestMethod.POST)
    public OrderDetails createOC(@RequestBody OrderDetails OD) throws SQLException {
        OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
        return orderDetailsDAO.createOD(OD);
    }

    @RequestMapping(value = "/order_details", method = RequestMethod.DELETE)
    public OrderDetails deleteODById(@RequestParam(value = "id") int id) throws SQLException {
        OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
        return orderDetailsDAO.deleteOD(id);
    }

    @RequestMapping(value = "/order_details", method = RequestMethod.PUT)
    public OrderDetails updateOD(@RequestBody OrderDetails OD) throws SQLException {
        OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
        return orderDetailsDAO.updateOD(OD);
    }

}
