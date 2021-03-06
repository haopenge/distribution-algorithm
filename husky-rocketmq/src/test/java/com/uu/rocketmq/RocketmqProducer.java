package com.uu.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @desc rocketMq 生产者
 * @author liuph
 * @date 2021/03/02 23:33
 */
public class RocketmqProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("lph_test_p");
        producer.setNamesrvAddr("172.16.7.75:9876");
        producer.setVipChannelEnabled(false);

        producer.start();

        for (int i = 0; i < 5; i++) {
            Message message = new Message("test", "TagA", "I am content".getBytes());
            producer.send(message);

            /*/ /消息路由策略
            producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    return list.get(0);
                }
            },"key-"+ i);*/
        }

    }
}
