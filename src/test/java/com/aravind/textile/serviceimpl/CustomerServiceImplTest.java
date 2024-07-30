package com.aravind.textile.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aravind.textile.model.Customer;
import com.aravind.textile.model.Order;
import com.aravind.textile.service.CustomerService;


@SpringBootTest
class CustomerServiceImplTest {
	
	@Autowired
	CustomerService customerService;
	

	@Test
	void testAddCustomer() {
		Order order = new Order(11,"TShirt",500);
		Customer customer = new Customer(11,"Ajith","7456734345","ajith@gmail.com","Dindigul",order);
		assertEquals("Success" , customerService.addCustomer(customer));
	}
	
	
	@Test
	void testAddCustomer1() {
		Customer customer =null;
		assertEquals("Failure" , customerService.addCustomer(customer));
	}
	
	@Test
	void testUpdateCustomer() {
		Order order = new Order(11," CollarTShirt",800);
		Customer customer = new Customer(11,"Ajith Kumar","7456734345","ajith@gmail.com","Dindigul",order);
		assertEquals("Success" , customerService.updateCustomer(customer));
	}
	
	@Test
	void testUpdateCustomer1() {
		Customer customer = null;
		assertEquals("Failure" , customerService.updateCustomer(customer));
	}
	
	@Test
	void testDeleteCustomer() {
		int id = 10;
		assertEquals("Success" , customerService.deleteCustomer(id));
	}
	
	@Test
	void testDeleteCustomer1() {
		int id = 10;
		assertEquals("Failure" , customerService.deleteCustomer(id));
	}
	
	@Test
	void testFindCustomer() {
		assertNotNull(customerService.getCustomer(11));
		
	}
	
	@Test
	void testFindCustomer1() {
		assertNull(customerService.getCustomer(10));
	}
	
	@Test
	void testGetCustomer() {
		assertNotNull(customerService.getAllCustomer());
	}
	
	@Test
	void testGetCustomer1() {
		assertNull(customerService.getAllCustomer());
	}
	
	
	
	
	
	

}
