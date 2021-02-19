package com.gupaoedu.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: qingshan
 * @Description: 咕泡学院，只为更好的你
 */
@Data
public class Order {

  private long orderId;
  private long userId;
  private Date createTime;
  private long totalPrice;

}
