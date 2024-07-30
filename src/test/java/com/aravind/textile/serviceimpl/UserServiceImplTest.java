package com.aravind.textile.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aravind.textile.model.User;
import com.aravind.textile.service.UserService;



@SpringBootTest
class UserServiceImplTest {
	
	@Autowired
	UserService userService;
	
	@Test
	void testRegisterUser() {
		User user = new User(18,"ajith","ajith","ajith@gmail.com","ajith123");
		assertEquals("Success", userService.addUser(user));
		
	}
	
	@Test
	void testRegisterUser1() {
		User user = null;
		assertEquals("Failure", userService.addUser(user));
		
	}
	
	@Test
	void testLoginUser() {
		
		assertNotNull(userService.login("ajith", "ajith123"));
		
	}
	

}
