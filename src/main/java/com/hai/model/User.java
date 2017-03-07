package com.hai.model;

/**
 * Created by as on 2017/3/6.
 */
public class User {
    private int id;
    private int age;
    private String name;
    private String sex;
    private Address address;

    public User() {
    }

    public User(int age, String name, String sex, Address address) {
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
