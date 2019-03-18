package com.spring.aop.pointcut.advisor.composable;

import com.spring.aop.pointcut.advisor.composable.config.ComposableConfiguration;
import com.spring.aop.pointcut.advisor.composable.service.AnminalService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComposableMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComposableConfiguration.class);
        AnminalService anminalService = applicationContext.getBean("animalProxy", AnminalService.class);
        if (anminalService != null) {
            anminalService.eat();
        }
    }
}
