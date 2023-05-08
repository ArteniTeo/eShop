package com.example.eShop.controller;

import com.example.eShop.dao.OrderDetailsDAO;
import com.example.eShop.dao.OrderItemDAO;
import com.example.eShop.dao.ShoppingCartItemDAO;
import com.example.eShop.entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class OrderDetailsController {

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;
    @Autowired
    private OrderItemDAO orderItemDAO;
    @Autowired
    private ShoppingCartItemDAO shoppingCartItemDAO;

    @RequestMapping(value = "/order_detail", method = RequestMethod.GET)
    public OrderDetails getODById(@RequestParam(value = "orderId") int id) throws SQLException {
        return orderDetailsDAO.findODById(id);
    }

    @RequestMapping(value = "/order_details", method = RequestMethod.GET)
    public List<OrderDetails> getODsById(@RequestParam(value = "customerId") int id) throws SQLException {
        return orderDetailsDAO.findODsById(id);
    }

    @RequestMapping(value = "/finalise_order", method = RequestMethod.POST)
    public OrderDetails createOD(@RequestParam(value = "customerId") int customerId,
                                 @RequestParam(value = "totalPrice") int totalPrice,
                                 @RequestParam(value = "paymentId") int paymentId,
                                 @RequestParam(value = "deliveryAddress") String address,
                                 @RequestParam(value = "date") String date) throws SQLException {
        OrderDetails OD = new OrderDetails(customerId, totalPrice, paymentId, address, date);

        //CREATE ORDER DETAILS
        OrderDetails orderDetails = orderDetailsDAO.createOrderDetails(OD);
        // SELECT ALL SHOPPING CART ITEMS AND ADD EACH AS A ORDER ITEM
        orderItemDAO.createOrderItemsFromShoppingCart(orderDetails.getCustomerId(), orderDetails.getId() );
        // DELETE ALL SHOPPING CART ITEMS OF THE CUSTOMER
        shoppingCartItemDAO.deleteShoppingCartItemByCustomerId(orderDetails.getCustomerId());

        return new OrderDetails();
    }

    @RequestMapping(value = "/order_details", method = RequestMethod.DELETE)
    public OrderDetails deleteODById(@RequestParam(value = "id") int id) throws SQLException {
        return orderDetailsDAO.deleteOD(id);
    }

    @RequestMapping(value = "/order_details", method = RequestMethod.PUT)
    public OrderDetails updateOD(@RequestBody OrderDetails OD) throws SQLException {
        return orderDetailsDAO.updateOD(OD);
    }

}
