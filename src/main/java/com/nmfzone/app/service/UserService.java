package com.nmfzone.app.service;

import java.io.Serializable;
import java.util.List;

import com.nmfzone.app.model.User;

public interface UserService extends Serializable
{

	void create(User user);

	List<User> getAll();

	void deleteById(Long userId);

	User findById(Long userId);

	void update(User user);

}
