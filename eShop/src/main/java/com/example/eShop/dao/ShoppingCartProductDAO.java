package com.example.eShop.dao;

import com.example.eShop.DataBaseConnection;
import com.example.eShop.entity.ShoppingCartProduct;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ShoppingCartProductDAO {

    public ShoppingCartProduct findSCPsById(int id) throws SQLException {

        ShoppingCartProduct foundSCP = null;
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id, product_id, quantity FROM public.shopping_cart_products WHERE shopping_cart_id = " + id);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            foundSCP = new ShoppingCartProduct(rs.getLong("id"), rs.getLong("product_id"), rs.getInt("quantity"));
            foundSCP.setId(id);
        }
        return foundSCP;
    }

    public ShoppingCartProduct createSCP(ShoppingCartProduct SCP) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO public.shopping_cart_products (product_id, shopping_cart_id, quantity) VALUES ( ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, SCP.getProductId());
            preparedStatement.setLong(1, SCP.getShoppingCartId());
            preparedStatement.setLong(1, SCP.getQuantity());

            preparedStatement.executeUpdate();

            generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            SCP.setId(generatedKeys.getLong(1));
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

        return SCP;
    }

    public ShoppingCartProduct deleteSCP(long id) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.shopping_cart_products WHERE id = " + id);

        try {
            if (preparedStatement != null) {
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ShoppingCartProduct updateSCP(ShoppingCartProduct SCP) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("UPDATE public.shopping_cart_products SET quantity=? WHERE id = " + SCP.getId());

            preparedStatement.setLong(1, SCP.getQuantity());

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

        return SCP;
    }
}
