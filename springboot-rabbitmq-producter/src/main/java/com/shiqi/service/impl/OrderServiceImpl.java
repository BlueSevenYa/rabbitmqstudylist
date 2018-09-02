package com.shiqi.service.impl;

import com.alibaba.fastjson.JSON;
import com.shiqi.constant.Constants;
import com.shiqi.entity.BrokerMessageLog;
import com.shiqi.entity.Order;
import com.shiqi.mapper.BrokerMessageLogMapper;
import com.shiqi.mapper.OrderMapper;
import com.shiqi.product.RabbitOrderSender;
import com.shiqi.service.OrderService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-09-01-19:23
 */
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;

    @Autowired
    private RabbitOrderSender rabbitOrderSender;

    @Override
    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    @Override
    public void createOrder(Order order) {
        Date orderTime=new Date();
        orderMapper.insertOrder(order);

        BrokerMessageLog brokerMessageLog=new BrokerMessageLog();
        brokerMessageLog.setId(order.getMessageId());
        brokerMessageLog.setMessage(JSON.toJSONString(order));
        brokerMessageLog.setStatus("0");
        brokerMessageLog.setNextRetry(DateUtils.addMinutes(orderTime, Constants.ORDER_TIMEOUT));
        brokerMessageLog.setCreateTime(new Date());
        brokerMessageLog.setUpdateTime(new Date());
        brokerMessageLogMapper.insertBML(brokerMessageLog);

        rabbitOrderSender.sendOrder(order);
    }
}
