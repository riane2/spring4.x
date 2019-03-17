package com.java.proxy.monitor;

import com.java.proxy.bean.MethodProxy;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description monitor
 */
public class PerformanceMonitor {
    private static ThreadLocal<MethodProxy> records = new ThreadLocal<>();

    public static void begin(String methodId) {
        System.out.println("begin monitor..." + methodId);
        MethodProxy proxy = new MethodProxy(methodId);
        records.set(proxy);
    }

    public static void end() {
        System.out.println("end monitor...");
        records.get().printPerformance();
    }

}
