package com.nmfzone.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nmfzone.app.dao.UserDao;
import com.nmfzone.app.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserDao dao;

	public void create(User user)
	{
		dao.create(user);
	}

	public List<User> getAll()
	{
		return dao.getAll();
	}

	public void deleteById(Long userId)
	{
		dao.deleteById(userId);
	}

	public User findById(Long userId)
	{
		return dao.findById(userId);
	}

	public void update(User user)
	{
		dao.update(user);
	}

}
