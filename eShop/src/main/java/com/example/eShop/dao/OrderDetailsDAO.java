package com.example.eShop.dao;

import com.example.eShop.DataBaseConnection;
import com.example.eShop.entity.OrderDetails;

import java.sql.*;

public class OrderDetailsDAO {

    public OrderDetails findODById(int id) throws SQLException {

        OrderDetails foundOD = null;
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT customer_id, total_price, payment_id, delivery_address, date FROM public.order_details WHERE id = " + id);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            foundOD = new OrderDetails(rs.getLong("customer_id"), rs.getLong("total_price"), rs.getLong("payment_id"), rs.getString("delivery_address"), rs.getDate("date"));
            foundOD.setId(id);
        }
        return foundOD;
    }

    public OrderDetails createOD(OrderDetails OD) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO public.order_details (customer_id, total_price, payment_id, delivery_address, date) VALUES (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, OD.getCustomerId());
            preparedStatement.setLong(2, OD.getTotalPrice());
            preparedStatement.setLong(3, OD.getPaymentId());
            preparedStatement.setString(4, OD.getDeliveryAddress());
            preparedStatement.setDate(5, OD.getDate());

            preparedStatement.executeUpdate();

            generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            OD.setId(generatedKeys.getLong(1));
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

        return OD;
    }

    public OrderDetails deleteOD(long id) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.order_details WHERE id = " + id);

        try {
            if (preparedStatement != null) {
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public OrderDetails updateOD(OrderDetails OD) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("UPDATE public.order_details SET customer_id=?, total_price=?, payment_id=?, delivery_address=?, date=? WHERE id = " + OD.getId());

            preparedStatement.setLong(1, OD.getCustomerId());
            preparedStatement.setLong(2, OD.getTotalPrice());
            preparedStatement.setLong(3, OD.getPaymentId());
            preparedStatement.setString(4, OD.getDeliveryAddress());
            preparedStatement.setDate(5, OD.getDate());

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

        return OD;
    }

}
