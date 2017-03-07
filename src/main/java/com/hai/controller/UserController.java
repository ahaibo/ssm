package com.hai.controller;

import com.hai.model.User;
import com.hai.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by as on 2017/3/2.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    public UserController() {
        System.out.println("Construct UserController...");
    }

    public List<User> findAll() {
        return this.userService.findAll();
    }

    public void add(User user) {

    }

    public void update(User user) {

    }

    public void delete(User user) {

    }
}
