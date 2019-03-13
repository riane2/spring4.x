package com.spring.ioc.placeholder;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySources;

/**
 * @author lixiongxiong
 * @date 2019/3/13
 * @description main
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Cat.class);
        Cat cat = context.getBean(Cat.class);

        PropertySourcesPlaceholderConfigurer placeholderConfigurer = context.getBean(PropertySourcesPlaceholderConfigurer.class);
        PropertySources propertySources =
                placeholderConfigurer.getAppliedPropertySources();
        //propertySources.get("")


        System.out.println(cat);
    }
}
