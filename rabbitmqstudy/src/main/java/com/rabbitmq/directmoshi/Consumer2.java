package com.rabbitmq.directmoshi;

import com.rabbitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-08-30-23:39
 */

public class Consumer2 {
    private final static String QUEUE_NAME = "queue_direct_2";
    private final static String EXCHANGE_NAME = "exchange_direct";

    public static void main(String[] argv) throws Exception {

        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 绑定队列到交换机, BindingKey为 insert delete update
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "insert");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "update");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "delete");

        channel.basicQos(1);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, false, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("获取:" + message);
            Thread.sleep(200);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
