package com.example.eShop.entity;

public class OrderItem {

    private long id;
    private long productId;
    private long orderId;
    private long productPrice;
    private long quantity;

    public OrderItem() {
    }

    public OrderItem(long productId, long orderId, long productPrice, long quantity) {
        this.productId = productId;
        this.orderId = orderId;
        this.productPrice = productPrice;
        this.quantity = quantity;
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

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(long productPrice) {
        this.productPrice = productPrice;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
