package com.example.eShop.dao;

import com.example.eShop.DataBaseConnection;
import com.example.eShop.entity.OrderItem;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class OrderItemDAO {


    public OrderItem findOIById(long id) throws SQLException {

        OrderItem foundOI = null;
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT product_id, order_id, product_price, quantity FROM public.order_items WHERE id = ?");
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            foundOI = new OrderItem(rs.getLong("product_id"), rs.getLong("order_id"), rs.getLong("product_price"), rs.getInt("quantity"));
            foundOI.setId(id);
        }
        return foundOI;
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

