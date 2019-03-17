package com.spring.aop.pointcut.advisor.staticadviosr;

import com.spring.aop.pointcut.advisor.service.WaiterService;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description static advisor
 */
public class MyStaticAdvisor extends StaticMethodMatcherPointcutAdvisor {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        if (method.getName().contains("hello")) {
            return true;
        }
        return false;
    }

    /**
     * 只对WaiterService及其子类进行切面
     *
     * @return
     */
    @Override
    public ClassFilter getClassFilter() {
        return WaiterService.class::isAssignableFrom;
    }

    /**
     * 一般需要指定顺序
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 1;
    }
}
