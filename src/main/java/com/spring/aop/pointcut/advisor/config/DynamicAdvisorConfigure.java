package com.spring.aop.pointcut.advisor.config;

import com.spring.aop.pointcut.advisor.advice.MyBeforeAdvice;
import com.spring.aop.pointcut.advisor.dyanmicadvisor.MyDynamicPonitCun;
import com.spring.aop.pointcut.advisor.service.ShellerService;
import com.spring.aop.pointcut.advisor.service.WaiterService;
import com.spring.aop.pointcut.advisor.staticadviosr.MyStaticAdvisor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description config
 */
@Configuration
@ComponentScan(basePackages = "com.spring.aop.pointcut.advisor")
public class DynamicAdvisorConfigure {

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        DefaultPointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor();
        /**
         * 切面必须指定增强内容
         */
        pointcutAdvisor.setAdvice(new MyBeforeAdvice());
        pointcutAdvisor.setPointcut(new MyDynamicPonitCun());
        return pointcutAdvisor;
    }


    @Bean("waiterProxy")
    public ProxyFactoryBean waiterService() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.addAdvisor(defaultPointcutAdvisor());
        proxyFactoryBean.setProxyTargetClass(true);
        proxyFactoryBean.setTarget(new WaiterService());
        return proxyFactoryBean;
    }


}
