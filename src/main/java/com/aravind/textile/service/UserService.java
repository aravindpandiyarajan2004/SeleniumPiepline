package com.aravind.textile.service;

import java.util.Optional;

import com.aravind.textile.model.User;

public interface UserService {

	public String addUser(User user);

	Optional<User> authenticate(String username, String password);

}
