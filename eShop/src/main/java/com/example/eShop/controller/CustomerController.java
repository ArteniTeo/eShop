package com.example.eShop.controller;

import com.example.eShop.dao.CustomerDAO;
import com.example.eShop.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class CustomerController {

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Customer getCustomerById(@RequestParam(value = "id") int id) throws SQLException {
        CustomerDAO customerDAO = new CustomerDAO();

        return customerDAO.findCustomerById(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) throws SQLException {
        CustomerDAO customerDAO = new CustomerDAO();
        return customerDAO.createCustomer(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.DELETE)
    public Customer deleteCustomerById(@RequestParam(value = "id") int id) throws SQLException {
        CustomerDAO customerDAO = new CustomerDAO();
        return customerDAO.deleteCustomer(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public Customer updateCustomer(@RequestBody Customer customer) throws SQLException {
        CustomerDAO customerDAO = new CustomerDAO();
        return customerDAO.updateCustomer(customer);
    }

}