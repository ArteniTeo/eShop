package com.example.eShop.dao;

import com.example.eShop.DataBaseConnection;
import com.example.eShop.entity.Customer;

import java.sql.*;

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

    public Customer createCustomer(String username, String password, String firstName, String lastName) throws SQLException {

        Customer createdCustomer = null;
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO public.customers (username, password, first_name, last_name) VALUES (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);

            preparedStatement.executeUpdate();

            createdCustomer = new Customer(username, password, firstName, lastName);

            generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            createdCustomer.setId(generatedKeys.getLong(1));
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

        return createdCustomer;
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

}
