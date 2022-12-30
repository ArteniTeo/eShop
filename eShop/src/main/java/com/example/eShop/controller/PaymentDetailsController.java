package com.example.eShop.controller;

import com.example.eShop.dao.PaymentDetailsDAO;
import com.example.eShop.entity.PaymentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

public class PaymentDetailsController {

    @Autowired
    private PaymentDetailsDAO paymentDetailsDAO;

    @RequestMapping(value = "/payment_details", method = RequestMethod.GET)
    public PaymentDetails getPDById(@RequestParam(value = "id") int id) throws SQLException {
        return paymentDetailsDAO.findPDById(id);
    }

    @RequestMapping(value = "/payment_details", method = RequestMethod.POST)
    public PaymentDetails createPD(@RequestBody PaymentDetails PD) throws SQLException {
        return paymentDetailsDAO.createPD(PD);
    }

    @RequestMapping(value = "/payment_details", method = RequestMethod.DELETE)
    public PaymentDetails deletePDById(@RequestParam(value = "id") int id) throws SQLException {
        return paymentDetailsDAO.deletePD(id);
    }

    @RequestMapping(value = "/payment_details", method = RequestMethod.PUT)
    public PaymentDetails updatePD(@RequestBody PaymentDetails PD) throws SQLException {
        return paymentDetailsDAO.updatePD(PD);
    }

}
