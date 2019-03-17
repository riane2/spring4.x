package com.java.proxy.handle;

import com.java.proxy.monitor.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description handle
 */
public class PerformHandle implements InvocationHandler {

    //目标业务类
    private Object object;

    public PerformHandle(Object object) {
        this.object = object;
    }

    /**
     *
     * @param proxy 最终生成的代理实例，一般不会用到
     * @param method 被代理目标对象的具体某个方法
     * @param args 代理方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * 方法之前前后进行监控操作
         */
        PerformanceMonitor.begin(object.getClass().getName() + "." + method.getName());
        Object obj = method.invoke(object, args);
        PerformanceMonitor.end();
        return obj;
    }
}
