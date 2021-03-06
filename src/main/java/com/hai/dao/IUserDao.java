package com.hai.dao;

import com.hai.model.User;

import java.util.List;

/**
 * Created by as on 2017/3/6.
 */
public interface IUserDao {
    int add(User user);

    int delete(User user);

    int deleteById(Integer userId);

    int update(User user);

    User getById(Integer userId);

    List<User> find();
}
