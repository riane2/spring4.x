package com.spring.aop.introduction;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description config
 */
@Configuration
@ComponentScan("com.spring.aop.introduction")
public class IntroductionConfiguration {

    @Bean
    public ProxyFactoryBean proxyFactoryBean(MyIntroductionInterceptor introductionInterceptor) {
        DogService dogService = new DogServiceImpl();
        ProxyFactoryBean factoryBean = new ProxyFactoryBean();
        /**
         * 需要添加引介增强需要实现的接口
         */
        factoryBean.setInterfaces(MyCatEnabled.class);
        /**
         * 引介增强只能通过CGLIB的方式实现，即通过创建子类的方式实现
         */
        factoryBean.setProxyTargetClass(true);
        factoryBean.setTarget(dogService);
        factoryBean.addAdvice(introductionInterceptor);
        return factoryBean;
    }
}
