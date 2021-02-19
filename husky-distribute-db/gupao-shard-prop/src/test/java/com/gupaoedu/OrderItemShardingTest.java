package com.gupaoedu;

import com.gupaoedu.entity.OrderItem;
import com.gupaoedu.service.OrderItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;

/**
 * 绑定表的分库分表策略
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = "com.gupaoedu.mapper")
public class OrderItemShardingTest {
    @Resource
    OrderItemService orderItemService;

    @Test
    public void insert(){

        orderItemService.insert();
    }

    @Test
    public void select(){
        OrderItem orderItem1 = orderItemService.getOrderItemByItemId(1);
        System.out.println("------orderItem1:"+orderItem1);

        OrderItem orderItem2 = orderItemService.getOrderItemByItemId(2);
        System.out.println("------orderItem2:"+orderItem2);
    }

}

