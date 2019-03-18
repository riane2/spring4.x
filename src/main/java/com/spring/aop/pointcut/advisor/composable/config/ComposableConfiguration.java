package com.spring.aop.pointcut.advisor.composable.config;

import com.spring.aop.pointcut.advisor.advice.MyBeforeAdvice;
import com.spring.aop.pointcut.advisor.composable.advisor.MyControlFlowPointcut;
import com.spring.aop.pointcut.advisor.composable.service.AnminalService;
import com.spring.aop.pointcut.advisor.composable.service.HorseService;
import com.spring.aop.pointcut.advisor.composable.service.TigerService;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.aop.pointcut.advisor.composable")
public class ComposableConfiguration {


    private ComposablePointcut pointcut() {
        //ComposablePointcut composablePointcut = new ComposablePointcut();
        /**
         * 为AnminalService的eat方法设置一个流程切点
         */
        ControlFlowPointcut controlFlowPointcut = new ControlFlowPointcut(AnminalService.class, "eat");
        /**
         * 设置一个方法切面：只匹配HorseService及其子类的eat方法
         */
        NameMatchMethodPointcut methodPointcut = new NameMatchMethodPointcut();
        methodPointcut.addMethodName("eat");
        methodPointcut.setClassFilter(HorseService.class::isAssignableFrom);
        /**
         * 并集：两个条件都必须满足
         */
        return (ComposablePointcut) Pointcuts.intersection(controlFlowPointcut, methodPointcut);
        /*composablePointcut = composablePointcut.intersection(controlFlowPointcut);
        return composablePointcut.intersection((Pointcut) methodPointcut);*/
    }

    @Bean("animalProxy")
    public ProxyFactoryBean proxyFactoryBean() {
        HorseService horseService = new HorseService();
        TigerService tigerService = new TigerService();
        AnminalService anminalService = new AnminalService(horseService, tigerService);
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setProxyTargetClass(true);
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        ControlFlowPointcut controlFlowPointcut = new MyControlFlowPointcut(AnminalService.class, "eat");

        defaultPointcutAdvisor.setPointcut(controlFlowPointcut);
        defaultPointcutAdvisor.setAdvice(new MyBeforeAdvice());
        proxyFactoryBean.addAdvisor(defaultPointcutAdvisor);
        proxyFactoryBean.setTarget(anminalService);
        return proxyFactoryBean;
    }

}
