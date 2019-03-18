package com.spring.aop.autoproxy.beanname.config;

import com.spring.aop.pointcut.advisor.advice.MyBeforeAdvice;
import com.spring.aop.pointcut.advisor.service.ShellerService;
import com.spring.aop.pointcut.advisor.service.WaiterService;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.aop.autoproxy.beanname")
public class BeanNameConfig {

    @Bean
    public MyBeforeAdvice myBeforeAdvice() {
        return new MyBeforeAdvice();
    }

    @Bean("waiter")
    public WaiterService waiterService() {
        return new WaiterService();
    }

    @Bean("sheller")
    public ShellerService shellerService() {
        return new ShellerService();
    }

    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
        /**
         * 容器中以er结尾的BeanName都会被创建代理,一般直接指定名称
         */
        // proxyCreator.setBeanNames("*er");
        proxyCreator.setBeanNames("waiter", "sheller");
        /**
         * 强制使用cglib动态代理
         */
        proxyCreator.setOptimize(true);
        /**
         * 设置Advice的名字
         */
        proxyCreator.setInterceptorNames("myBeforeAdvice");
        return proxyCreator;
    }

}
