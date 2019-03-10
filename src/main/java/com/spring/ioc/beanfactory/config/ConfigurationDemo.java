package com.spring.ioc.beanfactory.config;

import com.spring.ioc.beanfactory.bean.Car;
import com.spring.ioc.beanfactory.postprocessor.PostProDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lixiongxiong
 * @date 2019/3/10
 * @description configuration
 */
@Configuration
@ComponentScan(basePackages = "com.spring.ioc")
public class ConfigurationDemo {

    @Bean
    public Car car(){
        Car car = new Car();
        car.setPrice(123.345f);
        car.setName("DaZhong");
        return car;
    }
}
