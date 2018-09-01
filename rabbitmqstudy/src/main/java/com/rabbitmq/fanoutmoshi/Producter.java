package com.rabbitmq.fanoutmoshi;

import com.rabbitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-08-30-23:20
 */

public class Producter {

    private final static String EXCHANGE_NAME="exchange_fanout";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection= ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        String message="Hello fanout";

        channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());

        channel.close();
        connection.close();

    }

}
