package com.example.eShop.dao;

import com.example.eShop.DataBaseConnection;
import com.example.eShop.entity.ShoppingCart;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ShoppingCartDAO {

    public ShoppingCart findSCByCustomerId(int customerId) throws SQLException {

        ShoppingCart foundSC = null;
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id, total_price FROM public.shopping_carts WHERE customer_id = " + customerId);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            foundSC = new ShoppingCart(rs.getLong("id"), rs.getLong("total_price"));
            foundSC.setCustomerId(customerId);
        }
        return foundSC;
    }

    public ShoppingCart createSC(ShoppingCart SC) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO public.shopping_carts (customer_id) VALUES (?);", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, SC.getCustomerId());

            preparedStatement.executeUpdate();

            generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            SC.setId(generatedKeys.getLong(1));
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

        return SC;
    }

    public ShoppingCart deleteSC(long id) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.shopping_carts WHERE id = " + id);

        try {
            if (preparedStatement != null) {
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ShoppingCart updateSC(ShoppingCart SC) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("UPDATE public.shopping_carts SET total_price=? WHERE customer_id = " + SC.getCustomerId());

            preparedStatement.setLong(1, SC.getTotalPrice());

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

        return SC;
    }

}
