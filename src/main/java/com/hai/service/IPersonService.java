package com.hai.service;

import com.hai.model.Person;

import java.util.List;

/**
 * Created by as on 2017/3/6.
 */
public interface IPersonService {

    Person selectByPrimaryKey(Integer id);

    public List<Person> selectAllPersons();

    int deleteByPrimaryKey(Integer id);
}
