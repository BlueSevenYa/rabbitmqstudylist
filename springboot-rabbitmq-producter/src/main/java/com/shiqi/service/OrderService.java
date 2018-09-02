package com.shiqi.service;

import com.shiqi.entity.Order;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-09-01-19:23
 */
public interface OrderService {

    int insertOrder(Order order);

    void createOrder(Order order);

}
