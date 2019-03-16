package com.spring.ioc.eventpublis;

import com.spring.ioc.eventpublis.event.EventDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.ioc.eventpublis")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        applicationContext.publishEvent(new EventDemo(applicationContext,1));
    }

}
