package com.example.eShop.dao;

import com.example.eShop.DataBaseConnection;
import com.example.eShop.entity.OrderItem;
import org.springframework.stereotype.Repository;
import org.w3c.dom.ls.LSInput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderItemDAO {


    public List<OrderItem> findOIById(long id) throws SQLException {

        OrderItem foundOI = null;
        List<OrderItem> orderItems = new ArrayList<>();
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.order_items o JOIN public.products p ON o.product_id = p.id Where o.order_id = ?");
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            foundOI = new OrderItem(rs.getLong("id"), rs.getString("product_name"), rs.getLong("product_id"), rs.getLong("order_id"), rs.getLong("product_price"), rs.getInt("quantity"));
            orderItems.add(foundOI);
        }
        return orderItems;
    }

    public OrderItem createOI(OrderItem OI) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO public.order_items (product_id, order_id, product_price, quantity) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, OI.getProductId());
            preparedStatement.setLong(2, OI.getOrderId());
            preparedStatement.setLong(3, OI.getProductPrice());
            preparedStatement.setLong(4, OI.getQuantity());

            preparedStatement.executeUpdate();

            generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            OI.setId(generatedKeys.getLong(1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return OI;
    }

    public void createOrderItemsFromShoppingCart(long customerId, long orderId) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;

        OrderItem foundOI = null;
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.shopping_cart_items sh JOIN public.products p ON sh.product_id = p.id Where sh.customer_id = ?");
        statement.setLong(1, customerId);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            foundOI = new OrderItem(rs.getLong("product_id"), orderId, rs.getLong("price"), rs.getInt("quantity"));

            try {
                preparedStatement = connection.prepareStatement("INSERT INTO public.order_items (product_id, order_id, product_price, quantity) VALUES (?, ?, ?, ?);");

                preparedStatement.setLong(1, foundOI.getProductId());
                preparedStatement.setLong(2, foundOI.getOrderId());
                preparedStatement.setLong(3, foundOI.getProductPrice());
                preparedStatement.setLong(4, foundOI.getQuantity());

                preparedStatement.executeUpdate();
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }

    public OrderItem deleteOI(long id) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.order_items WHERE id = ?");
        preparedStatement.setLong(1, id);

        try {
            if (preparedStatement != null) {
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public OrderItem updateOI(OrderItem OI) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("UPDATE public.order_items SET product_id=?, order_id=?, product_price=?, quantity=? WHERE id = ?");
            preparedStatement.setLong(1, OI.getId());

            preparedStatement.setLong(1, OI.getProductId());
            preparedStatement.setLong(2, OI.getOrderId());
            preparedStatement.setLong(3, OI.getProductPrice());
            preparedStatement.setLong(4, OI.getQuantity());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return OI;
    }
}

