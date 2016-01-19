package com.nmfzone.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nmfzone.app.model.User;

@Repository("userDao")
public class UserDao extends AbstractDao implements IUserDao
{

    public void saveUser(User user)
    {
		persist(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUser()
    {
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}

	public void deleteUserById(String id)
    {
		Query query = getSession().createSQLQuery("delete from user where id = :id");
		query.setString("id", id);
		query.executeUpdate();
	}

	public User findById(String id)
    {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		return (User) criteria.uniqueResult();
	}

	public void updateUser(User user)
    {
		getSession().update(user);
	}

}
