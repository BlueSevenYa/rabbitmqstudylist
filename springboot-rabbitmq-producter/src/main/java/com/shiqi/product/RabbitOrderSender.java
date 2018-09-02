package com.shiqi.product;

import com.shiqi.constant.Constants;
import com.shiqi.entity.Order;
import com.shiqi.mapper.BrokerMessageLogMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-09-01-23:09
 */
@Component
public class RabbitOrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;

    final RabbitTemplate.ConfirmCallback confirmCallback=new RabbitTemplate.ConfirmCallback(){

        @Override
        public void confirm(CorrelationData correlationData, boolean b, String s) {
            System.err.println("correlationData"+correlationData);
            String messageId=correlationData.getId();
            if(b){
                brokerMessageLogMapper.changeBrokerMessageLogStatus(messageId, Constants.ORDER_SEND_SUCCESS,new Date());
            }else{
                System.err.println("异常处理。。。");
            }
        }
    };

    public void sendOrder(Order order){
        rabbitTemplate.setConfirmCallback((RabbitTemplate.ConfirmCallback) confirmCallback);
        CorrelationData correlationData=new CorrelationData(order.getMessageId());
        rabbitTemplate.convertAndSend("order-exchange","order.ABC",order,correlationData);

    }

}
