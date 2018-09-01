package com.rabbitmq.simplemoshi;

import com.rabbitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-08-30-22:32
 */

public class Producter {

    private final static String QUEUE_NAME="queue_simple";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection= ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        String message="Hello simple";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());

        channel.close();
        connection.close();
    }

}
