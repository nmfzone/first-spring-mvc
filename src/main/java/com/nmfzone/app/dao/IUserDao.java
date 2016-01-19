package com.nmfzone.app.dao;

import java.util.List;

import com.nmfzone.app.model.User;

public interface IUserDao
{

    void saveUser(User user);

	List<User> getAllUser();

	void deleteUserById(String id);

	User findById(String id);

	void updateUser(User user);

}
