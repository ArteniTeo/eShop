package com.example.eShop.dao;

import com.example.eShop.DataBaseConnection;
import com.example.eShop.entity.ShoppingCartItem;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ShoppingCartItemDAO {

<<<<<<< HEAD
    public ShoppingCartItem findSCIsByCustomerId(int customer_id) throws SQLException {

        ShoppingCartItem foundSCI = null;
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id, product_id, quantity FROM public.shopping_cart_items WHERE customer_id = " + customer_id);
=======
    public ShoppingCartItem findSCIsById(int customerId) throws SQLException {

        ShoppingCartItem foundSCI = null;
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id, product_id, quantity FROM public.shopping_cart_items WHERE customer_id = " + customerId);
>>>>>>> 8306b2476c2c9d8cd2f4f2fd7cce2386f1c26c89
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            foundSCI = new ShoppingCartItem(rs.getLong("id"), rs.getLong("product_id"), rs.getInt("quantity"));
<<<<<<< HEAD
            foundSCI.setCustomerId(customer_id);
=======
            foundSCI.setCustomerId(customerId);
>>>>>>> 8306b2476c2c9d8cd2f4f2fd7cce2386f1c26c89
        }
        return foundSCI;
    }

    public ShoppingCartItem createSCI(ShoppingCartItem SCI) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO public.shopping_cart_items (product_id, customer_id, quantity) VALUES ( ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, SCI.getProductId());
            preparedStatement.setLong(2, SCI.getCustomerId());
            preparedStatement.setLong(3, SCI.getQuantity());

            preparedStatement.executeUpdate();

            generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            SCI.setId(generatedKeys.getLong(1));
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

        return SCI;
    }

    public ShoppingCartItem deleteSCI(long id) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.shopping_cart_items WHERE id = " + id);

        try {
            if (preparedStatement != null) {
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ShoppingCartItem updateSCI(ShoppingCartItem SCI) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("UPDATE public.shopping_cart_items SET quantity=? WHERE id = " + SCI.getId());

            preparedStatement.setLong(1, SCI.getQuantity());

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

        return SCI;
    }
}
