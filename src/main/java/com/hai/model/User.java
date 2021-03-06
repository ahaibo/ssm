package com.hai.model;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by as on 2017/3/6.
 */
public class User {
    private int id;

    @Size(min = 15, max = 80, message = "{user.age.range}")
    private int age;
    @NotNull(message = "{msg.notnull}")
    private String name;
    private String sex;

    @Past(message = "{msg.birthday}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Email(message = "{msg.email")
    private String email;
    private Address address;

    public User() {
    }

    public User(int age, String name, String sex, Address address) {
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.address = address;
    }

    public static User newInstance() {
        return new User();
    }

    public static User newInstance(int age, String name, String sex, Address address) {
        return new User(age, name, sex, address);
    }

    public static User mock() {
        return User.newInstance(20, "hai", "男", Address.mock());
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
