# 分布式锁
   解决多进程，之间的并发问题，分布式系统中多节点访问出现的问题, 例：下单数量>库存数量
   
   分布式锁主要解决的问题：无序性

## redis
   redis的实现方式：
   
   - 通过setNX,设置标记，多个进程抢标记，谁拿到执行谁的？
   - 配合getSet,防止并发删除标记异常
  
- 测试结果：
```text
使用jMeter测试,效果明显:(可通过controller中的两个url进行测试比较)
    前提：总数为3
    /redis/subscribe/nolock: 在不适用锁的情况下:预约数为10,出现异常
    /redis/subscribe : 使用锁的情况下：预约数为3,正常
```
   
# 参考
   (分布式锁)[https://juejin.im/entry/5a502ac2518825732b19a595]
