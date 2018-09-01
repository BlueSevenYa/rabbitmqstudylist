package com.rabbitmq.workmoshi;

import com.rabbitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-08-30-23:06
 */

public class Producter {

    private final static String QUEUE_NAME="queue_work";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection= ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        for(int i=0;i<50;i++){
            String message="Hello work"+i;
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());

            Thread.sleep(i*10);
        }

        channel.close();
        connection.close();
    }

}
