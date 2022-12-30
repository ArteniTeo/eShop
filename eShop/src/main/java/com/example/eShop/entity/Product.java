package com.example.eShop.entity;

public class Product {

    private long id;
    private String productName;
    private long price;
    private String category;
    private int stock;

    public Product() {
    }

    public Product(String productName, long price, String category, int stock) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
