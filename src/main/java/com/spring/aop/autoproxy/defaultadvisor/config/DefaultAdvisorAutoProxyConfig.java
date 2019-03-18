package com.spring.aop.autoproxy.defaultadvisor.config;

import com.spring.aop.pointcut.advisor.advice.MyBeforeAdvice;
import com.spring.aop.pointcut.advisor.service.ShellerService;
import com.spring.aop.pointcut.advisor.service.WaiterService;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.aop.autoproxy.defaultadvisor")
public class DefaultAdvisorAutoProxyConfig {

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
    public RegexpMethodPointcutAdvisor regexpMethodPointcutAdvisor() {
        RegexpMethodPointcutAdvisor pointcutAdvisor = new RegexpMethodPointcutAdvisor();
        pointcutAdvisor.setPattern(".*hello.*");
        pointcutAdvisor.setAdvice(myBeforeAdvice());
        return pointcutAdvisor;
    }

    /**
     * 自动扫描容器中的Advisor，并为其生成匹配的代理
     *
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

}
