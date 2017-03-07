package com.hai.service.impl;

import com.hai.base.BaseService;
import com.hai.dao.impl.UserDaoImpl;
import com.hai.model.User;
import com.hai.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by as on 2017/3/6.
 */
@Service("userService")
public class UserServiceImpl extends BaseService implements IUserService {

    @Autowired
    private UserDaoImpl userDao;

    public int add(User user) {
        System.out.println("\nUserServiceImpl.add...");
        return this.userDao.add(user);
    }

    public int delete(User user) {
        System.out.println("\nUserServiceImpl.delete...");
        return this.userDao.delete(user);
    }

    public int deleteById(Integer userId) {
        System.out.println("\nUserServiceImpl.deleteById...");
        return this.userDao.deleteById(userId);
    }

    public int update(User user) {
        System.out.println("\nUserServiceImpl.update...");
        return this.userDao.update(user);
    }

    public User getById(Integer userId) {
        System.out.println("\nUserServiceImpl.getById...");
        return this.userDao.getById(userId);
    }

    public List<User> find() {
        System.out.println("\nUserServiceImpl.find...");
        return this.userDao.find();
    }


}
