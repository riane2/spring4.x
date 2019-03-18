package com.spring.aop.autoproxy.beanname;

import com.spring.aop.autoproxy.beanname.config.BeanNameConfig;
import com.spring.aop.pointcut.advisor.service.ShellerService;
import com.spring.aop.pointcut.advisor.service.WaiterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 */
public class BeanNameDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanNameConfig.class);
        WaiterService waiter = context.getBean("waiter", WaiterService.class);
        waiter.hello("riane");
        waiter.end("riane");
        ShellerService sheller = context.getBean("sheller", ShellerService.class);
        context.getBean("sheller", ShellerService.class);
        sheller.hello("riane");
    }
}
