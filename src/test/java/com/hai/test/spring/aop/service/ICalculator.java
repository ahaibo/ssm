package com.hai.test.spring.aop.service;

/**
 * Created by as on 2017/3/7.
 */
public interface ICalculator {
    Number add(Number a, Number b);

    Number subtract(Number a, Number b);

    Number multiply(Number a, Number b);

    Number divide(Number a, Number b);

    Number odd(Number a, Number b);
}
