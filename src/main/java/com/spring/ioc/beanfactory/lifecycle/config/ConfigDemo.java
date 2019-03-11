package com.spring.ioc.beanfactory.lifecycle.config;

import com.spring.ioc.beanfactory.lifecycle.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.ioc.beanfactory.lifecycle")
public class ConfigDemo {


    @Bean(initMethod = "init", destroyMethod = "destroyMe")
    public Student student() {
        Student student = new Student();
        student.setName("riane");
        student.setSex("M");
        return student;
    }

}
