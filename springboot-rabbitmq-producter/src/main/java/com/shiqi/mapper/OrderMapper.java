package com.shiqi.mapper;

import com.shiqi.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-09-01-19:21
 */
@Repository(value = "orderMapper")
public interface OrderMapper {

    int insertOrder(Order order);

}
