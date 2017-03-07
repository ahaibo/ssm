package com.hai.test.mybatis;

import com.hai.model.Person;
import com.hai.service.IPersonService;
import com.hai.test.common.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by as on 2017/3/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis-test.xml")
public class TestPerson extends BaseTest {

    @Resource
    private IPersonService personService;

    @Test
    public void test1() {
        Person person = personService.selectByPrimaryKey(2);
        logger.debug(person);
        jsonToString(person);
        assertThat(person, notNullValue());
    }
}
