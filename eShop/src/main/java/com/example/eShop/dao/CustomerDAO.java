package com.example.eShop.dao;

import com.example.eShop.DataBaseConnection;
import com.example.eShop.entity.Customer;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class CustomerDAO {

    public Customer findCustomerById(long id) throws SQLException {

        Customer foundCustomer = null;
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT username, password, first_name, last_name FROM public.customers WHERE id = ?");
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            foundCustomer = new Customer();

            foundCustomer.setId(id);
            foundCustomer.setUsername(rs.getString("username"));
            foundCustomer.setPassword(rs.getString("password"));
            foundCustomer.setFirstName(rs.getString("first_name"));
            foundCustomer.setLastName(rs.getString("last_name"));

        }
        return foundCustomer;

        //TODO close all resources (connection and preparedStatement + rs)
    }

    public Customer createCustomer(Customer customer) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO public.customers (username, password, first_name, last_name) VALUES (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, customer.getUsername());
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

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return customer;
    }

    public void deleteCustomer(long id) throws SQLException {

        Customer createdCustomer = null;
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.customers WHERE id = ?");
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    public Customer updateCustomer(Customer customer) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("UPDATE public.customers SET username=?, password=?, first_name=?, last_name=? WHERE id = " + customer.getId());

            preparedStatement.setString(1, customer.getUsername());
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

    public Customer login(String username, String password) throws SQLException {

        Customer foundCustomer = new Customer();
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id, first_name, last_name FROM public.customers WHERE username = ? AND password = ?");
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {

            foundCustomer.setId(rs.getLong(("id")));
            foundCustomer.setUsername(username);
            foundCustomer.setPassword(password);
            foundCustomer.setFirstName(rs.getString("first_name"));
            foundCustomer.setLastName(rs.getString("last_name"));

        }
        return foundCustomer;
    }

}
