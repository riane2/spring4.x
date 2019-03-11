package com.spring.ioc.beanfactory.lifecycle;

import com.spring.ioc.beanfactory.lifecycle.bean.Student;
import com.spring.ioc.beanfactory.lifecycle.config.ConfigDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigDemo.class);
        Student student = context.getBean(Student.class);
        System.out.println(student.toString());
        context.close();
    }
}
