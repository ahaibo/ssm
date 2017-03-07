import com.hai.model.Person;
import com.hai.service.IPersonService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by as on 2017/3/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class TestMybatis {
    private static Logger logger = Logger.getLogger(TestMybatis.class);
//    private ApplicationContext ac;

    @Resource
    private IPersonService personService;

//    @Before
//    public void before() {
//        ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
//        personService = (IPersonService) ac.getBean("personService");
//    }

    @Test
    public void test1() {
        Person person = personService.selectByPrimaryKey(1);
        logger.debug(person.getName());
        System.out.println(ToStringBuilder.reflectionToString(person));
    }
}
