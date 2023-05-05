package com.example.eShop.entity;

public class PaymentDetails {

    private long id;
    private String cardOwnerName;
    private String cardNumber;
    private String cardExpirationDate;
    private int cvv;
    private long customerId;

    public PaymentDetails() {
    }

    public PaymentDetails(long id, String cardOwnerName, String cardNumber, String cardExpirationDate, int cvv) {
        this.id = id;
        this.cardOwnerName = cardOwnerName;
        this.cardNumber = cardNumber;
        this.cardExpirationDate = cardExpirationDate;
        this.cvv = cvv;
    }
    public PaymentDetails(String cardOwnerName, String cardNumber, String cardExpirationDate, int cvv, long customerId) {
        this.cardOwnerName = cardOwnerName;
        this.cardNumber = cardNumber;
        this.cardExpirationDate = cardExpirationDate;
        this.cvv = cvv;
        this.customerId = customerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardOwnerName() {
        return cardOwnerName;
    }

    public void setCardOwnerName(String cardOwnerName) {
        this.cardOwnerName = cardOwnerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
