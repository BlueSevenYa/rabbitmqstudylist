package com.shiqi.controller;

import com.shiqi.entity.Order;
import com.shiqi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-09-01-19:31
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/insertorder")
    public Order insertOrder(){
        Order order=new Order("1","2","3");
        int i=orderService.insertOrder(order);
        System.out.println(i);
        return order;
    }

}
