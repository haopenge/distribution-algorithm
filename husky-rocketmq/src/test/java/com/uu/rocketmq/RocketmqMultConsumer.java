package com.uu.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuph
 * @desc
 * @date 2021/03/03 10:41
 */
public class RocketmqMultConsumer {

    public static void main(String[] args) throws MQClientException {

        int count = Runtime.getRuntime().availableProcessors() * 2 + 1;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(count, count, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(6));

        executor.execute(new ConsumerTask(1));
     //   executor.execute(new ConsumerTask(2));
     //   executor.execute(new ConsumerTask(3));
    }

    static class ConsumerTask implements Runnable{
        public Integer threadIndex = 0;
        public ConsumerTask(Integer threadIndex ){
            this.threadIndex = threadIndex;
        }

        @Override
        public void run() {
            DefaultMQPushConsumer consumer=
                    new DefaultMQPushConsumer("consumer_group" + 1);
            consumer.setNamesrvAddr("172.16.7.75:9876");
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            try {
                consumer.subscribe("test","*");
            } catch (MQClientException e) {
                e.printStackTrace();
            }

            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
                                                                ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    System.out.println("--->   " +  threadIndex + " ....Receive Message: "+list);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS; //签收
                }
            });

       /* consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {

                MessageExt  messageExt=list.get(0);
                //TODO  --
                // Throw Exceptio
                // 重新发送该消息
                // DLQ（通用设计）
                if(messageExt.getReconsumeTimes()==3){  //消息重发了三次
                    //持久化 消息记录表
                    return ConsumeOrderlyStatus.SUCCESS; //签收
                }
                return ConsumeOrderlyStatus.SUCCESS; //签收
            }
        });*/

            try {
                consumer.start();
            } catch (MQClientException e) {
                e.printStackTrace();
            }
        }
    }
}
