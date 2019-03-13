package com.spring.ioc.placeholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author lixiongxiong
 * @date 2019/3/13
 * @description cat
 */
@Configuration
@PropertySource("demo.properties")
public class Cat {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    @Bean
    public PropertySourcesPlaceholderConfigurer configurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }



    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
