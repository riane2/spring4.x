package com.spring.aop.pointcut.advisor.dyanmicadvisor;

import com.spring.aop.pointcut.advisor.service.WaiterService;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description dynamic
 */
public class MyDynamicPonitCun extends DynamicMethodMatcherPointcut {
    private static List<String> names = new CopyOnWriteArrayList<>();

    static {
        names.add("riane");
        names.add("riane5");
    }

    /**
     * 动态匹配
     *
     * @param method
     * @param targetClass
     * @param args
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println("动态匹配：..." + method.getName() + ",参数为：" + Arrays.toString(args));
        if (args.length > 0) {
            if (names.contains(args[0])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 静态匹配
     *
     * @param method
     * @param targetClass
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("静态匹配：..." + method.getName());
        if (method.getName().equals("hello")) {
            return true;
        }
        return false;
    }


    @Override
    public ClassFilter getClassFilter() {
        System.out.println("classFilter...");
        return WaiterService.class::isAssignableFrom;
    }

}
