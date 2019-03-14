package com.spring.ioc.propertyeditor;

import com.spring.ioc.propertyeditor.bean.Owner;
import com.spring.ioc.propertyeditor.config.MyCustomEditConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyCustomEditConfig.class);
        Owner owner = context.getBean(Owner.class);
        System.out.println(owner.toString());
    }
}
