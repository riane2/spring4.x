package com.spring.aop.surround.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description method interceptor
 */
@Component
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object[] objects = invocation.getArguments();
        String methodName = invocation.getMethod().getName();
        System.out.println("begin " + methodName + Arrays.toString(objects));
        Object proceed = invocation.proceed();
        System.out.println("end " + methodName + Arrays.toString(objects));
        return proceed;
    }
}
