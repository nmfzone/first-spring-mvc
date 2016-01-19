package com.nmfzone.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nmfzone.app.dao.UserDao;
import com.nmfzone.app.model.User;

@Service("userService")
@Transactional
public class UserService implements IUserService
{

	@Autowired
	private UserDao dao;

	public void saveUser(User user)
	{
		dao.saveUser(user);
	}

	public List<User> getAllUser()
	{
		return dao.getAllUser();
	}

	public void deleteUserById(String id)
	{
		dao.deleteUserById(id);
	}

	public User findById(String id)
	{
		return dao.findById(id);
	}

	public void updateUser(User user)
	{
		dao.updateUser(user);
	}
}
