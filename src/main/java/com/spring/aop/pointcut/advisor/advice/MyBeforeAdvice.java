package com.spring.aop.pointcut.advisor.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description advice
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.err.println("before advice ....");
    }
}
