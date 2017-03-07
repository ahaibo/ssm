package com.hai.service;

import com.hai.model.User;

import java.util.List;

/**
 * Created by as on 2017/3/6.
 */
public interface IUserService {

    List<User> findAll();

    void add(User user);

    void update(User user);

    void delete(User user);
}
