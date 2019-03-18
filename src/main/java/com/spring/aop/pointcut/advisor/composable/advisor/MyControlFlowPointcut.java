package com.spring.aop.pointcut.advisor.composable.advisor;

import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class MyControlFlowPointcut extends ControlFlowPointcut {

    private Class<?> clazz;

    @Nullable
    private String methodName;

    public MyControlFlowPointcut(Class<?> clazz, String methodName) {
        super(clazz, methodName);
        this.clazz = clazz;
        this.methodName = methodName;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {

        for (StackTraceElement element : new Throwable().getStackTrace()) {
            if (element.getClassName().contains(this.clazz.getName()) &&
                    (this.methodName == null || element.getMethodName().equals(this.methodName))) {
                return true;
            }
        }
        return false;
    }
}
