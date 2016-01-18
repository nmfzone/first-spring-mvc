package com.nmfzone.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nmfzone.app.model.User;

@Repository
@Transactional(readOnly = false)
public class UserDao
{

    @PersistenceContext
    EntityManager entityManager;
    public void saveUserDetail(User user)
    {
        entityManager.persist(user);
        System.out.println("--Data Saved--");
    }

}
