package com.spring.ioc.beanfactory.lifecycle.instanatation;

import com.spring.ioc.beanfactory.lifecycle.bean.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

@Component
public class MyInstanatationBeanPostProcessor implements InstantiationAwareBeanPostProcessor {


    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanClass == Student.class) {
            System.out.println("MyInstanatationBeanPostProcessor postProcessBeforeInstantiation...");
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student) {
            System.out.println("MyInstanatationBeanPostProcessor postProcessAfterInstantiation...");
        }
        return true;
    }

    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (bean instanceof Student) {
            System.out.println("MyInstanatationBeanPostProcessor postProcessProperties...");
        }
        return null;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (bean instanceof Student) {
            System.out.println("MyInstanatationBeanPostProcessor postProcessPropertyValues...");
        }

        return pvs;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student) {
            System.out.println("MyInstanatationBeanPostProcessor postProcessBeforeInitialization...");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student) {
            System.out.println("MyInstanatationBeanPostProcessor postProcessAfterInitialization...");
        }
        return bean;
    }
}
