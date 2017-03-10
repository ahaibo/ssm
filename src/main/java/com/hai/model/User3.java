package com.hai.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by as on 2017/3/6.
 */
public class User3 {
    private int id;
    private int age;
    private String name;
    private String sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;

    private String email;

    public User3() {
    }

    public User3(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public static User3 newInstance() {
        return new User3();
    }

    public static User3 newInstance(int age, String name, String sex) {
        return new User3(age, name, sex);
    }

    public static User3 mock() {
        return User3.newInstance(20, "hai", "男");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
