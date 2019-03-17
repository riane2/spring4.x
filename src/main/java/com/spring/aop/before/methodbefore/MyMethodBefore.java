package com.spring.aop.before.methodbefore;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description method before
 */
public class MyMethodBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if (args.length > 0 && method.getName().contains("greet")) {
            System.out.println(method.getName());
            System.out.println("hello " + args[0]);
        }
        //method.invoke(target, args);
    }
}
