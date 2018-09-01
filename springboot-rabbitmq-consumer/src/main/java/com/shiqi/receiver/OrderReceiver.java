package com.shiqi.receiver;

import com.rabbitmq.client.Channel;
import com.shiqi.entity.Order;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-09-01-15:53
 */
@Component
public class OrderReceiver {

    @RabbitHandler
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "order-queue",durable = "true"),
                    exchange = @Exchange(name="order-exchange",durable = "true",type = "topic"),
                    key = "order.*"
            )
    )
    public void onOrderMessage(@Payload Order order,
                               Channel channel,
                               @Headers Map<String,Object> headers) throws IOException {
        //消费者操作
        System.out.println("====消费者开始接受消息=====");
        System.out.println("订单ID："+order.getId());

        Long deliveryTag= (Long) headers.get(AmqpHeaders.DELIVERY_TAG);

        //ack
        channel.basicAck(deliveryTag,false);
    }

}
