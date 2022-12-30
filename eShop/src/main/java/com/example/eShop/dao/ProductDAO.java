package com.example.eShop.dao;

import com.example.eShop.DataBaseConnection;
import com.example.eShop.entity.Product;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ProductDAO {

    public Product findProductById(int id) throws SQLException {

        Product foundProduct = null;
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT product_name, price, category, quantity FROM public.products WHERE id = " + id);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            foundProduct = new Product(rs.getString("product_name"), rs.getLong("price"), rs.getString("category"), rs.getInt("quantity"));
            foundProduct.setId(id);
        }
        return foundProduct;
    }

    public Product createProduct(Product product) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO public.products(product_name, price, category, stock) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setLong(2, product.getPrice());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setInt(4, product.getStock());

            preparedStatement.executeUpdate();

            generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            product.setId(generatedKeys.getLong(1));
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

        return product;
    }

    public Product deleteProduct(long id) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.products WHERE id = " + id);

        try {
            if (preparedStatement != null) {
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Product updateProduct(Product product) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("UPDATE public.products SET product_name=?, price=?, category=?, stock=? WHERE id = " + product.getId());

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setLong(2, product.getPrice());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setInt(4, product.getStock());

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

        return product;
    }
}
