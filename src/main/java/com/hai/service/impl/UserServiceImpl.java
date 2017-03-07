package com.hai.service.impl;

import com.hai.dao.IUserDao;
import com.hai.model.User;
import com.hai.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by as on 2017/3/6.
 */
@Component("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    public UserServiceImpl() {
        System.out.println("Construct UserServiceImpl...");
    }

    public List<User> findAll() {
        return null;
    }

    public void add(User user) {

    }

    public void update(User user) {

    }

    public void delete(User user) {

    }
}
