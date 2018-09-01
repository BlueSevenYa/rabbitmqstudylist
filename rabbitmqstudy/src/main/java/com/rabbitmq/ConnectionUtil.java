package com.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-08-30-22:27
 */

public class ConnectionUtil {

    public static Connection getConnection() throws IOException, TimeoutException {

        //connection工厂
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setHost("192.168.99.100");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("root");
        connectionFactory.setVirtualHost("/");

        //获得connection连接
        Connection connection=connectionFactory.newConnection();

        return connection;

    }

}
