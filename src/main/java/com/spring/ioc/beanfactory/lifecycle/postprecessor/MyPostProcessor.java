package com.spring.ioc.beanfactory.lifecycle.postprecessor;

import com.spring.ioc.beanfactory.lifecycle.bean.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student) {
            System.out.println("MyPostProcessor postProcessBeforeInitialization....");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student) {
            System.out.println("MyPostProcessor postProcessAfterInitialization....");
        }
        return bean;
    }
}
