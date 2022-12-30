package com.example.eShop.entity;

public class ShoppingCartItem {
    private long id;
    private long productId;
    private long shoppingCartId;
    private int quantity;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(long productId, long shoppingCartId) {
        this.productId = productId;
        this.shoppingCartId = shoppingCartId;
    }

    public ShoppingCartItem(long id, long productId, int quantity) {
        this.id = id;
        this.productId = productId;
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

    public long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
