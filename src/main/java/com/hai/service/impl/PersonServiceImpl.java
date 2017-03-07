package com.hai.service.impl;

import com.hai.base.BaseService;
import com.hai.dao.IPersonDao;
import com.hai.model.Person;
import com.hai.model.example.PersonExample;
import com.hai.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by as on 2017/3/6.
 */
@Service("personService")
public class PersonServiceImpl extends BaseService implements IPersonService {

    @Autowired
    private IPersonDao personDao;

    public Person selectByPrimaryKey(Integer id) {
        System.out.println(this.getClass().getName() + ".selectByPrimaryKey(" + id + ")");
        return this.personDao.selectByPrimaryKey(id);
    }

    public List<Person> selectAllPersons() {
        return this.personDao.selectByExample(new PersonExample());
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.personDao.deleteByPrimaryKey(id);
    }
}
