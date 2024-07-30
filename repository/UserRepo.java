package com.aravind.micro.repository;


import com.aravind.micro.model.User;


public interface UserRepo {
	public User findByUsername(String username);
	public void save(User user);
	public User login(String username, String password);


}
