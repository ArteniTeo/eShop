package com.example.eShop.dao;

import com.example.eShop.DataBaseConnection;
import com.example.eShop.controller.ShoppingCartController;
import com.example.eShop.entity.Customer;
import com.example.eShop.entity.ShoppingCart;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class CustomerDAO {

    public Customer findCustomerById(int id) throws SQLException {

        Customer foundCustomer = null;
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT username, password, first_name, last_name FROM public.customers WHERE id = " + id);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            foundCustomer = new Customer();

            foundCustomer.setId(id);
            foundCustomer.setUserName(rs.getString("username"));
            foundCustomer.setPassword(rs.getString("password"));
            foundCustomer.setFirstName(rs.getString("first_name"));
            foundCustomer.setLastName(rs.getString("last_name"));

        }
        return foundCustomer;
    }

    public Customer createCustomer(Customer customer) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO public.customers (username, password, first_name, last_name) VALUES (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, customer.getUserName());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getFirstName());
            preparedStatement.setString(4, customer.getLastName());

            preparedStatement.executeUpdate();

            generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            customer.setId(generatedKeys.getLong(1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Create a new Shopping Cart for every new Customer
            ShoppingCartController scc = new ShoppingCartController();
            scc.createSC(new ShoppingCart(customer.getId()));

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return customer;
    }

    public Customer deleteCustomer(long id) throws SQLException {

        Customer createdCustomer = null;
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.customers WHERE id = " + id);

        try {
            if (preparedStatement != null) {
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Customer updateCustomer(Customer customer) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("UPDATE public.customers SET username=?, password=?, first_name=?, last_name=? WHERE id = " + customer.getId());

            preparedStatement.setString(1, customer.getUserName());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getFirstName());
            preparedStatement.setString(4, customer.getLastName());

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

        return customer;
    }

}
