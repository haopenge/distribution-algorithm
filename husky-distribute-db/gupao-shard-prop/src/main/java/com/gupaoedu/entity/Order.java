package com.gupaoedu.entity;

import java.io.Serializable;

public class Order implements Serializable {
    private Integer orderId;

    private Integer userId;

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
        return " -------- Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                '}';
    }
}