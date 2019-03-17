package com.spring.aop.surround.config;

import com.spring.aop.surround.interceptor.MyMethodInterceptor;
import com.spring.aop.surround.service.CatService;
import com.spring.aop.surround.service.impl.CatServiceImpl;
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
@ComponentScan("com.spring.aop.surround")
public class MyConfig {


    @Bean
    public ProxyFactoryBean proxyFactoryBean(MyMethodInterceptor methodInterceptor) {
        ProxyFactoryBean factoryBean = new ProxyFactoryBean();
        factoryBean.addAdvice(methodInterceptor);
        try {
            factoryBean.setProxyInterfaces(new Class[]{CatService.class});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //factoryBean.addInterface(C);
        CatService catService = new CatServiceImpl();
        factoryBean.setTarget(catService);
        /**
         * 是否对类进行代理，而不是对接口进行代理，如果是true，则addInterface()方法就无效了，采用 CGLib代理
         */
        //factoryBean.setProxyTargetClass(true);
        return factoryBean;
    }
}
