package com.example.eShop.controller;

import com.example.eShop.dao.PaymentDetailsDAO;
import com.example.eShop.entity.PaymentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class PaymentDetailsController {

    @Autowired
    private PaymentDetailsDAO paymentDetailsDAO;

    @RequestMapping(value = "/payment_details", method = RequestMethod.GET)
    public PaymentDetails getPDById(@RequestParam(value = "customerId") int customerId) throws SQLException {
        return paymentDetailsDAO.findPDById(customerId);
    }

    @RequestMapping(value = "/payment_details", method = RequestMethod.POST)
    public PaymentDetails createPD(@RequestParam("cardOwnerName") String cardOwnerName,
                                   @RequestParam("cardNumber") String cardNumber,
                                   @RequestParam("cvv") int cvv,
                                   @RequestParam("expirationDate") String expirationDate,
                                   @RequestParam("customerId") long customerId)  throws SQLException {
        PaymentDetails PD = new PaymentDetails();
        PD.setCardOwnerName(cardOwnerName);
        PD.setCardNumber(cardNumber);
        PD.setCvv(cvv);
        PD.setCardExpirationDate(expirationDate);
        PD.setCustomerId(customerId);
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
