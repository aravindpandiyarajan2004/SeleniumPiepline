package com.aravind.textile.repository;

import java.util.Optional;

import com.aravind.textile.model.User;

public interface UserRepo {

	public String save(User user);

	public Optional<User> findByUsernameAndPassword(String username, String password);

}
