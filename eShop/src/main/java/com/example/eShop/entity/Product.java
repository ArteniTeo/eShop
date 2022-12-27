package com.example.eShop.entity;

public class Product {

    private long id;
    private String productName;
    private long price;
    private String category;

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
