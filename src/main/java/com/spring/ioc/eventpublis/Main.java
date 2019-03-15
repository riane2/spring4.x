package com.spring.ioc.eventpublis;

import com.spring.ioc.eventpublis.event.EventDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();


        applicationContext.registerBean("", EventDemo.class);
    }

}
