package com.nmfzone.app.dao;

import java.io.Serializable;
import java.util.List;

import com.nmfzone.app.model.User;

public interface UserDao extends Serializable
{

    void create(User user);

    List<User> getAll();

    void deleteById(Long id);

    User findById(Long id);

    void update(User user);

}
