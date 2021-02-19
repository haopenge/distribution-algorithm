package com.gupaoedu.entity;


import lombok.Data;

/**
 * @Author: qingshan
 * @Description: 咕泡学院，只为更好的你
 */
@Data
public class OrderItem {

    private long userId;
    private long orderItemId;
    private long orderId;
    private String name;
    private long price;

}
