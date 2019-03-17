package com.spring.aop.pointcut.advisor.config;

import com.spring.aop.pointcut.advisor.advice.MyBeforeAdvice;
import com.spring.aop.pointcut.advisor.service.ShellerService;
import com.spring.aop.pointcut.advisor.service.WaiterService;
import com.spring.aop.pointcut.advisor.staticadviosr.MyStaticAdvisor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description config
 */
@Configuration
@ComponentScan("com.spring.aop.pointcut.advisor")
public class StaticAdvisorConfigure {

    @Bean
    public StaticMethodMatcherPointcutAdvisor staticMethodMatcherPointcutAdvisor() {
        MyStaticAdvisor staticAdvisor = new MyStaticAdvisor();
        /**
         * 切面必须指定增强内容
         */
        staticAdvisor.setAdvice(new MyBeforeAdvice());
        return staticAdvisor;
    }

    private ProxyFactoryBean proxyFactoryBean() {
        ProxyFactoryBean factoryBean = new ProxyFactoryBean();
        factoryBean.addAdvisor(staticMethodMatcherPointcutAdvisor());
        factoryBean.setProxyTargetClass(true);
        return factoryBean;
    }


    @Bean("waiterProxy")
    public ProxyFactoryBean waiterService() {
        ProxyFactoryBean proxyFactoryBean = proxyFactoryBean();
        proxyFactoryBean.setTarget(new WaiterService());
        return proxyFactoryBean;
    }

    @Bean("shellerProxy")
    public ProxyFactoryBean shellerService() {
        ProxyFactoryBean proxyFactoryBean = proxyFactoryBean();
        proxyFactoryBean.setTarget(new ShellerService());
        return proxyFactoryBean;
    }

}
