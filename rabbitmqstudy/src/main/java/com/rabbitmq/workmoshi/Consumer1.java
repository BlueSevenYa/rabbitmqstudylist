package com.rabbitmq.workmoshi;

import com.rabbitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-08-30-23:06
 */

public class Consumer1 {

    private final static String QUEUE_NAME="queue_work";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection= ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        System.out.println("等待消息ing");

        channel.basicQos(1);

        QueueingConsumer consumer=new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME,false,consumer);

        while(true){
            QueueingConsumer.Delivery delivery=consumer.nextDelivery();
            String message=new String(delivery.getBody());
            System.out.println("接收："+message);
            Thread.sleep(100);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        }
    }

}
