package com.example.market.Model;

public class ProductsModel {
    private String product_name;
    private String product_image;
    private String product_origin;
    private String product_weight;
    private String product_price;

    public ProductsModel(String product_name, String product_image, String product_origin, String product_weight, String product_price) {
        this.product_name = product_name;
        this.product_image = product_image;
        this.product_origin = product_origin;
        this.product_weight = product_weight;
        this.product_price = product_price;

    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public String getProduct_origin() {
        return product_origin;
    }

    public void setProduct_origin(String product_origin) {
        this.product_origin = product_origin;
    }

    public String getProduct_weight() {
        return product_weight;
    }

    public void setProduct_weight(String product_weight) {
        this.product_weight = product_weight;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }
}