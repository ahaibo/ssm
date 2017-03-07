package com.hai.service.impl;

import com.hai.dao.IPersonDao;
import com.hai.model.Person;
import com.hai.model.PersonExample;
import com.hai.service.IPersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by as on 2017/3/6.
 */
@Service("personService")
public class PersonServiceImpl implements IPersonService {

    @Resource
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
