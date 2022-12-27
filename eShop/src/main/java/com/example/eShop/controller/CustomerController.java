package com.example.eShop.controller;

import com.example.eShop.dao.CustomerDAO;
import com.example.eShop.entity.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class CustomerController {

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Customer getCustomerById(@RequestParam(value = "id") int id) throws SQLException {
        CustomerDAO customerDAO = new CustomerDAO();

        return customerDAO.findCustomerById(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer createCustomer(
            @RequestParam(value = "username") String username
            , @RequestParam(value = "password") String password
            , @RequestParam(value = "firstName") String firstName
            , @RequestParam(value = "lastName") String lastName) throws SQLException {
        CustomerDAO customerDAO = new CustomerDAO();

        return customerDAO.createCustomer(username, password, firstName, lastName);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.DELETE)
    public Customer deleteCustomerById(@RequestParam(value = "id") int id) throws SQLException {
        CustomerDAO customerDAO = new CustomerDAO();
        return customerDAO.deleteCustomer(id);
    }

}