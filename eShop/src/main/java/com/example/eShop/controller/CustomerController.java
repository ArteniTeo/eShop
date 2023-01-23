package com.example.eShop.controller;

import com.example.eShop.dao.CustomerDAO;
import com.example.eShop.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Customer getCustomerById(@RequestParam(value = "id") int id) throws SQLException {
        return customerDAO.findCustomerById(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Customer login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) throws SQLException {
        return customerDAO.login(username, password);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Customer signup(@RequestBody Customer customer) throws SQLException {
        return customerDAO.createCustomer(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) throws SQLException {
        return customerDAO.createCustomer(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.DELETE)
    public void deleteCustomerById(@RequestParam(value = "id") int id) throws SQLException {
        customerDAO.deleteCustomer(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public Customer updateCustomer(@RequestBody Customer customer) throws SQLException {
        return customerDAO.updateCustomer(customer);
    }

}