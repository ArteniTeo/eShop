package com.example.eShop.entity;

public class Product {

    private long id;
    private String productName;
    private long price;
    private String category;
    private int quantity;

    public Product() {
    }

    public Product(String productName, long price, String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public Product(String productName, long price, String category, int quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product { " +
                "id = " + id +
                ", productName = '" + productName + '\'' +
                ", price = " + price +
                ", category = '" + category + '\'' +
                '}';
    }
}
