package com.spring.aop.pointcut.advisor;

import com.spring.aop.pointcut.advisor.config.DynamicAdvisorConfigure;
import com.spring.aop.pointcut.advisor.config.StaticAdvisorConfigure;
import com.spring.aop.pointcut.advisor.service.ShellerService;
import com.spring.aop.pointcut.advisor.service.WaiterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 两个service，只对waiterService的hello方法进行切面增强
 *
 * @author lixiongxiong
 * @date 2019/3/17
 * @description main
 */
public class DynamicAdvisorDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DynamicAdvisorConfigure.class);
        WaiterService waiterProxy = applicationContext.getBean("waiterProxy", WaiterService.class);
        waiterProxy.hello("riane");
        waiterProxy.hello("riane2");
        waiterProxy.end("riane");
    }
}
