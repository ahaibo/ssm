package com.hai.test.spring.aop;

import com.hai.test.spring.aop.service.impl.CalculatorImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by as on 2017/3/7.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis-test.xml");
        CalculatorImpl calc = (CalculatorImpl) ac.getBean("calculatorImpl");
        calc.add(1, 2);
        calc.subtract(10, 2);
        calc.multiply(2, 5);
        calc.divide(null, 3);
        calc.odd(10, 3);
    }
}
