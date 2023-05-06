package com.example.eShop.entity;

public class OrderDetails {

    private long id;
    private long customerId;
    private long totalPrice;
    private long paymentId;
    private String deliveryAddress;
    private String date;


    public OrderDetails() {
    }

    public OrderDetails(long id, long customerId, long totalPrice, long paymentId, String deliveryAddress, String date) {
        this.id = id;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.paymentId = paymentId;
        this.deliveryAddress = deliveryAddress;
        this.date = date;
    }
    public OrderDetails(long customerId, long totalPrice, long paymentId, String deliveryAddress, String date) {
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.paymentId = paymentId;
        this.deliveryAddress = deliveryAddress;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
