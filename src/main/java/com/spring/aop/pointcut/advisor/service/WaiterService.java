package com.spring.aop.pointcut.advisor.service;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description waiter service
 */
public class WaiterService {

    public void hello(String name){
        System.out.println("waiter hello "+name);
    }

    public void end(String name){
        System.out.println("waiter end "+name);
    }


}
