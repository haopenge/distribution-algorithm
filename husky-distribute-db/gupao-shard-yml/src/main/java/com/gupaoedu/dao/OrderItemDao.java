package com.gupaoedu.dao;

import com.gupaoedu.entity.OrderItem;

import java.util.List;

/**
 * @Author: qingshan
 * @Description: 咕泡学院，只为更好的你
 */
public interface OrderItemDao {

    void addOne(OrderItem orderItem);

    List<OrderItem> getByOrderId(int id);

    List<OrderItem> getOrderItemByPrice(int price);


}
