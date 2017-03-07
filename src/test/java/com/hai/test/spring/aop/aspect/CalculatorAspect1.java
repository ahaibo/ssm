package com.hai.test.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by as on 2017/3/7.
 */
@Order(1)//order可对同类通知排序，值越小越优先
@Aspect
@Component
public class CalculatorAspect1 {

    @Pointcut("execution(* com.hai.test.spring.aop.service.impl.CalculatorImpl.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void beforeMethod(JoinPoint joinPoint) {
        logMethod("beforeMethod", joinPoint);
    }

    @After("pointcut()")
    public void afterMethod(JoinPoint joinPoint) {
        logMethod("afterMethod", joinPoint);
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public Object afterReturningMethod(JoinPoint joinPoint, Object result) {
        logMethod("afterReturningMethod", joinPoint, "result: " + result);
        return result;
    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) {
        logMethod("afterThrowingMethod", joinPoint, "occurs exception: " + ex);
    }

    /**
     * 环绕通知必须携带 ProceedingJoinPoint 参数，且必须有返回值
     * 环绕通知类似于动态代理全过程，ProceedingJoinPoint 可决定目标方法是否被执行
     * 环绕通知的返回值即为目标方法的返回值
     *
     * @param point
     * @return
     */
    @Around("pointcut()")
    public Object aroundMethod(ProceedingJoinPoint point) {
        Object result = null;
        String methodName = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
        try {
            //模拟前置通知
            System.out.println("\naroundMethod method begins with " + methodName);
            //执行目标方法
            System.out.println("aroundMethod method exec with " + methodName);
            result = point.proceed();
            //模拟后置通知
            System.out.println("aroundMethod method ends with " + methodName);
        } catch (Throwable e) {
            //模拟异常通知
            System.out.println("aroundMethod method occurs with " + methodName + "\nerror msg: " + e.getMessage());
        } finally {
            System.out.println("aroundMethod method exec finally.\n");
        }
        return result;
    }

    private void logMethod(String methodName, JoinPoint joinPoint, Object... objects) {
        System.out.println(this.getClass().getName() + "." + methodName + " exec...with " +
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        if (null != objects && objects.length > 0) {
            System.out.println(Arrays.toString(objects));
        }
    }
}
