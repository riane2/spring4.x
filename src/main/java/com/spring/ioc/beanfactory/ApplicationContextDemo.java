package com.spring.ioc.beanfactory;

import com.spring.ioc.beanfactory.bean.Car;
import com.spring.ioc.beanfactory.config.ConfigurationDemo;
import com.spring.ioc.beanfactory.postprocessor.PostProDemo;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * {@linkplain ApplicationContext}:应用上下文，建立在BeanFactory基础之上，提供更多面向应用的功能
 * <p>
 * BeanFactory时Spring框架的基础设施，面向Spring本身
 * ApplicationContext面向使用Spring框架的开发者，几乎所有的应用场合都可以直接使用ApplicationContext而非BeanFactory
 */
public class ApplicationContextDemo {

    public static void main(String[] args) {
        //基于注解的applicationContext,还有基于文件系统的和基于类路径的
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationDemo.class);
        System.out.println(context.getApplicationName());


        Car car = context.getBean(Car.class);
        System.out.println(car.toString());

        PostProDemo bean = context.getBean(PostProDemo.class);
        if (bean == null) {
            System.out.println("bull");
        }
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        Map<String, InstantiationAwareBeanPostProcessor> beansOfType = context.getBeansOfType(InstantiationAwareBeanPostProcessor.class);
        for (Map.Entry<String, InstantiationAwareBeanPostProcessor> postProcessorEntry : beansOfType.entrySet()) {
            System.out.println(postProcessorEntry.getKey() + ": " + postProcessorEntry.getValue());
        }


    }


}
