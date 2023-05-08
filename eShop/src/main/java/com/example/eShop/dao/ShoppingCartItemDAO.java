package com.example.eShop.dao;

import com.example.eShop.DataBaseConnection;
import com.example.eShop.entity.ShoppingCartItem;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ShoppingCartItemDAO {

    public List<ShoppingCartItem> findSCIsByCustomerId(long customerId) throws SQLException {

        List<ShoppingCartItem> foundSCI = new ArrayList<>();
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.shopping_cart_items s JOIN public.products p ON s.product_id = p.id Where s.customer_id=?;");
        statement.setLong(1, customerId);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            ShoppingCartItem cartItem = new ShoppingCartItem(rs.getLong("id"), rs.getLong("product_id"), rs.getInt("quantity"));
            cartItem.setPrice(rs.getDouble("price"));
            cartItem.setProductName(rs.getString("product_name"));
            cartItem.setCustomerId(customerId);
            foundSCI.add(cartItem);
        }
        return foundSCI;
    }

    public ShoppingCartItem createSCI(long productId, long customerId, int quantity) throws SQLException {

        ShoppingCartItem SCI = null;
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO public.shopping_cart_items (product_id, customer_id, quantity) VALUES ( ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, productId);
            preparedStatement.setLong(2, customerId);
            preparedStatement.setLong(3, quantity);

            preparedStatement.executeUpdate();

            generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            SCI = new ShoppingCartItem(productId, customerId, quantity);
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

    public ShoppingCartItem deleteSCI(long sciID) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.shopping_cart_items WHERE id = ?");
        preparedStatement.setLong(1, sciID);

        try {
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ShoppingCartItem deleteShoppingCartItemByCustomerId(long customerId) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.shopping_cart_items WHERE customer_id = ?");
        preparedStatement.setLong(1, customerId);

        try {
            preparedStatement.executeUpdate();
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
            preparedStatement = connection.prepareStatement("UPDATE public.shopping_cart_items SET quantity=? WHERE id = ?");
            preparedStatement.setLong(1, SCI.getId());
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
