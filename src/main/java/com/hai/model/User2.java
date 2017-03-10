package com.hai.model;

import java.util.Date;

/**
 * Created by as on 2017/3/6.
 */
public class User2 {
    private int id;
    private int age;
    private String name;
    private String sex;

    private Date birthday;

    private String email;
    private Address address;

    public User2() {
    }

    public User2(int age, String name, String sex, Address address) {
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.address = address;
    }

    public static User2 newInstance() {
        return new User2();
    }

    public static User2 newInstance(int age, String name, String sex, Address address) {
        return new User2(age, name, sex, address);
    }

    public static User2 mock() {
        return User2.newInstance(20, "hai", "男", Address.mock());
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
