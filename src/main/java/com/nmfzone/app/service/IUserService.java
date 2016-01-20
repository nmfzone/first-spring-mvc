package com.nmfzone.app.service;

import java.util.List;

import com.nmfzone.app.model.User;

public interface IUserService
{

	void saveUser(User user);

	List<User> getAllUser();

	void deleteUserById(String id);

	User findById(String id);

	void updateUser(User user);
	
}
