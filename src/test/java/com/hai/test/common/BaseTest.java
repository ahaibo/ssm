package com.hai.test.common;

import com.hai.test.mybatis.TestPerson;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by as on 2017/3/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis-test.xml"})
public class BaseTest {
    protected static Logger logger = Logger.getLogger(TestPerson.class);
//    protected ApplicationContext ac;

//    @Before
//    protected void beforeMethod() {
//        ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
//    }

    protected void jsonToString(Object o) {
        jsonToString(null, o);
    }

    protected void jsonToString(String preMsg, Object o) {
        jsonToString(preMsg, o, null);
    }

    protected void jsonToString(String preMsg, Object o, String suffMsg) {
        if (null == o)
            System.out.println("obj is null..");
        else {
            if (null != preMsg && !preMsg.equals(""))
                System.out.println(preMsg + " ");
            System.out.println(ToStringBuilder.reflectionToString(o, ToStringStyle.JSON_STYLE));
            if (null != suffMsg && !suffMsg.equals(""))
                System.out.println(" " + suffMsg);
        }
    }
}
