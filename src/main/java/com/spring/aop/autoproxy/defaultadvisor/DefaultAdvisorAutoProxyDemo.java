package com.spring.aop.autoproxy.defaultadvisor;

import com.spring.aop.autoproxy.defaultadvisor.config.DefaultAdvisorAutoProxyConfig;
import com.spring.aop.pointcut.advisor.service.ShellerService;
import com.spring.aop.pointcut.advisor.service.WaiterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DefaultAdvisorAutoProxyDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DefaultAdvisorAutoProxyConfig.class);
        WaiterService waiter = context.getBean("waiter", WaiterService.class);
        waiter.hello("riane");
        waiter.end("riane");
        ShellerService sheller = context.getBean("sheller", ShellerService.class);
        sheller.hello("riane");
    }
}
