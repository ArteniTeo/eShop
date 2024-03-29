package com.example.eShop.entity;

public class ShoppingCartItem {
    private long id;
    private long productId;

    private String productName;
    private double price;
    private long customerId;
    private int quantity;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(long productId, long customerId) {
        this.productId = productId;
        this.customerId = customerId;
    }

    public ShoppingCartItem(long id, long productId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
