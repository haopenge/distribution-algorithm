package com.gupaoedu;

import com.gupaoedu.entity.Order;
import com.gupaoedu.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = "com.gupaoedu.mapper")
public class OrderShardingTest {
    @Resource
    OrderService orderService;

    @Test
    public void insert(){

        orderService.insert();
    }

    @Test
    public void select(){
        Order order1 = orderService.getOrderInfoByOrderId(1);
        System.out.println("------order1:"+order1);

        Order order2 = orderService.getOrderInfoByOrderId(2);
        System.out.println("------order2:"+order2);
    }

}

