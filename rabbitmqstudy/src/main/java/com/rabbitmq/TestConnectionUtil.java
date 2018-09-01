package com.rabbitmq;

import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-08-30-22:30
 */

public class TestConnectionUtil {

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection=ConnectionUtil.getConnection();
        if(connection!=null){
            System.out.println("连接成功");
        }else{
            System.out.println("连接失败");
        }

    }

}
