package com.gupaoedu.entity;

public class OrderItem {
    private Integer itemId;

    private Integer orderId;

    private Integer userId;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return " -------- OrderItem{" +
                "itemId=" + itemId +
                ", orderId=" + orderId +
                ", userId=" + userId +
                '}';
    }
}