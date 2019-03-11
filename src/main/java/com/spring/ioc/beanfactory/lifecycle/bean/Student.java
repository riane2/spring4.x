package com.spring.ioc.beanfactory.lifecycle.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Student implements InitializingBean, DisposableBean {


    private String name;

    private String sex;


    public Student() {
        System.out.println("Student constructor...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Student setName...");
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        System.out.println("Student setSex...");
        this.sex = sex;
    }

    public void init() {
        System.out.println("Student init... ");
    }

    public void destroyMe() {
        System.out.println("Student destroyMethod...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Student postConstruct...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Student preDestroy....");
    }

    public void destroy() throws Exception {
        System.out.println("Student destroy...");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Student afterPropertiesSet...");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
