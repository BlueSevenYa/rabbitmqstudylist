package com.shiqi.product;

import com.shiqi.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-09-01-15:34
 */
@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrder(Order order){
        CorrelationData correlationData=new CorrelationData();
        correlationData.setId(order.getMessageId());
        /**
         * 定义交换机名称
         * 定义路由规则
         * 消息体
         * 消息唯一ID
         * */
        rabbitTemplate.convertAndSend("order-exchange",
                "order.abcd",
                order,
                correlationData);
    }

}
