package com.example.eShop.entity;

public class ShoppingCart {

    private long id;
    private long customerId;
    private long totalPrice;

    public ShoppingCart() {
    }

    public ShoppingCart(long customerId, long totalPrice) {
        this.customerId = customerId;
        this.totalPrice = totalPrice;
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
}
