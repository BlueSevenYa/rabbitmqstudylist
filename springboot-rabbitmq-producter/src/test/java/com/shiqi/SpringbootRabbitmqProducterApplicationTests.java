package com.shiqi;

import com.shiqi.entity.Order;
import com.shiqi.product.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqProducterApplicationTests {

	@Autowired
	private OrderSender orderSender;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSend1(){
		String messageID=System.currentTimeMillis()+"$"+ UUID.randomUUID().toString();
		Order order=new Order("20180901",
				"测试订单1",
				messageID);
		orderSender.sendOrder(order);
	}

}
