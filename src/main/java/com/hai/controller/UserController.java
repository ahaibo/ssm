package com.hai.controller;

import com.hai.base.BaseController;
import com.hai.model.User;
import com.hai.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by as on 2017/3/2.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/")
    public String login(User user) {
        System.out.println("UserController.login...");
        return "user/home";
    }

    @RequestMapping("/add")
    public String add(User user) {
        System.out.println("UserController.add()...");
        this.userService.add(user);
        return "user/add";
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String delete(User user) {
        System.out.println("UserController.delete()...");
        this.userService.delete(user);
        return "200";
    }

    @ResponseBody
    @RequestMapping("/deleteById/{userId}")
    public String deleteById(@PathVariable Integer userId) {
        System.out.println("UserController.deleteById()...");
        System.out.println();
        this.userService.deleteById(userId);
        return "200";
    }

    @RequestMapping("/update")
    public String update(@RequestBody User user) {
        System.out.println("UserController.update()...");
        this.userService.update(user);
        return "user/update";
    }

    @RequestMapping("/getById/{userId}")
    public String getById(@PathVariable Integer userId) {
        System.out.println("UserController.getById()...");
        this.userService.getById(userId);
        return "user/detail";
    }

    @RequestMapping("/list")
    public String find() {
        System.out.println("UserController.find()...");
        this.userService.find();
        return "user/list";
    }
}
