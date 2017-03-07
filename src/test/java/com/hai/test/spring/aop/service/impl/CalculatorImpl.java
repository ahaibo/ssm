package com.hai.test.spring.aop.service.impl;

import com.hai.test.spring.aop.service.ICalculator;
import org.springframework.stereotype.Component;

/**
 * Created by as on 2017/3/7.
 */
@Component
public class CalculatorImpl implements ICalculator {
    public Number add(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }

    public Number subtract(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }

    public Number multiply(Number a, Number b) {
        return a.doubleValue() * b.doubleValue();
    }

    public Number divide(Number a, Number b) {
        return a.doubleValue() / b.doubleValue();
    }

    public Number odd(Number a, Number b) {
        return a.doubleValue() % b.doubleValue();
    }
}
