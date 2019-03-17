package com.spring.aop.introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description main
 */
public class MainDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IntroductionConfiguration.class);
        DogService dogService = applicationContext.getBean("proxyFactoryBean", DogService.class);
        if (dogService instanceof DogService) {
            /**
             * 默认是没有开启介入增强的
             */
            dogService.eat();

            MyCatEnabled catEnabled = (MyCatEnabled) dogService;
            catEnabled.setEnabled(true);

            dogService.eat();

        }
    }
}
