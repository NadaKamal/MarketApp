package com.example.market.Model;

public class OrderItemsModel {

    private String productName;
    private String productCount;
    private String productPrice;

    public OrderItemsModel(String productName, String productCount, String productPrice) {
        this.productName = productName;
        this.productCount = productCount;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}