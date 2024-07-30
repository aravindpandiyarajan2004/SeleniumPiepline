package com.aravind.textile.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aravind.textile.model.Order;
import com.aravind.textile.service.OrderService;

@SpringBootTest
class OrderServiceImplTest {
	
	@Autowired
	OrderService orderService;

	@Test
	void testOrderUpdate() {
		Order order = new Order(7,"Shirt",500);
		assertEquals("Success",orderService.updateOrder(order));
		
	}
	
	@Test
	void testOrderUpdate1() {
		Order order = null;
		assertEquals("Failure",orderService.updateOrder(order));
		
	}
	
	@Test
	void testOrderFind() {
		assertNotNull(orderService.getOrder(9));
	}
	
	@Test
	void testOrderFind1() {
		assertNull(orderService.getOrder(4));
	}
	
	@Test
	void testAllOrder() {
		assertNotNull(orderService.getAllOrder());
	}

}
