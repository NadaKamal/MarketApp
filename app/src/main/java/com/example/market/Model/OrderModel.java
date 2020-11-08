package com.example.market.Model;

import java.util.ArrayList;

public class OrderModel {

    private String orderNum;
    private String totalOrder;
    private String deliveryPrice;
   private ArrayList<OrderItemsModel> orderItems;
   private String orderStatus;

    public OrderModel(String orderNum, String totalOrder, String deliveryPrice,
                      ArrayList<OrderItemsModel> orderItems,
                      String orderStatus) {
        this.orderNum = orderNum;
        this.totalOrder = totalOrder;
        this.deliveryPrice = deliveryPrice;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(String totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(String deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public ArrayList<OrderItemsModel> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItemsModel> orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}