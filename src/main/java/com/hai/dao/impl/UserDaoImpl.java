package com.hai.dao.impl;

import com.hai.base.BaseDao;
import com.hai.dao.IUserDao;
import com.hai.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by as on 2017/3/6.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDao implements IUserDao {

    public int add(User user) {
        System.out.println("\nUserDaoImpl.add...");
        return 0;
    }

    public int delete(User user) {
        System.out.println("\nUserDaoImpl.delete...");
        return 0;
    }

    public int deleteById(Integer userId) {
        System.out.println("\nUserDaoImpl.deleteById...");
        return 0;
    }

    public int update(User user) {
        System.out.println("\nUserDaoImpl.update...");
        return 0;
    }

    public User getById(Integer userId) {
        System.out.println("\nUserDaoImpl.getById...");
        return null;
    }

    public List<User> find() {
        System.out.println("\nUserDaoImpl.find...");
        return null;
    }
}
