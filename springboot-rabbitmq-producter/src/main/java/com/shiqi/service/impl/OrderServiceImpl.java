package com.shiqi.service.impl;

import com.shiqi.entity.Order;
import com.shiqi.mapper.OrderMapper;
import com.shiqi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }
}
