package com.nmfzone.app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nmfzone.app.dao.AbstractDao;
import com.nmfzone.app.dao.UserDao;

import com.nmfzone.app.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao
{

    @Override
    public void create(User user)
    {
        persist(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAll()
    {
        Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
    }

    @Override
    public void deleteById(Long id)
    {
        Query query = getSession().createSQLQuery("DELETE FROM users WHERE id = :id");
        query.setString("id", Long.toString(id));
        query.executeUpdate();
    }

    @Override
    public User findById(Long id)
    {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id", id));
        return (User) criteria.uniqueResult();
    }

    @Override
    public void update(User user)
    {
        getSession().update(user);
    }

}
