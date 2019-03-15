package com.spring.ioc.eventpublis.beandef;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

public class MyBeanDefinitionCustomizer implements BeanDefinitionCustomizer {


    private final int value;

    public MyBeanDefinitionCustomizer(int value){
        this.value = value;
    }


    @Override
    public void customize(BeanDefinition bd) {
        BeanDefinitionBuilder beanDefinitionBuilder;
        if (value == 1){
        }
    }
}
