package com.example.market.Model;

public class CategoriesModel {

    private String categoryImg;
    private String categoryName;

    public CategoriesModel(String categoryImg, String categoryName) {
        this.categoryImg = categoryImg;
        this.categoryName = categoryName;

    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}