package com.example.eShop.entity;

public class ShoppingCart {

    private long id;
    private long customerId;
    private long total_price;

    public ShoppingCart() {
    }

    public ShoppingCart(long customerId, long total_price) {
        this.customerId = customerId;
        this.total_price = total_price;
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

    public long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(long total_price) {
        this.total_price = total_price;
    }
}
