package com.rabbitmq.topicmoshi;

import com.rabbitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-08-31-00:12
 */

public class Producter {

    private final static String EXCHANGE_NAME = "exchange_topic";

    public static void main(String[] argv) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        String message = "Hello world";
        // 发送消息, 指定RoutingKey
        channel.basicPublish(EXCHANGE_NAME, "item.delete", null, message.getBytes());

        channel.close();
        connection.close();
    }

}
