package com.rabbitmq.directmoshi;

import com.rabbitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-08-30-23:38
 */

public class Producter {

    private final static String EXCHANGE_NAME = "exchange_direct";

    public static void main(String[] argv) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        String message = "Hello world";
        // 发送消息, RoutingKey为 insert
        channel.basicPublish(EXCHANGE_NAME, "insert", null, message.getBytes());

        channel.close();
        connection.close();
    }

}
