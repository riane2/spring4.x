package com.spring.aop.before.service.impl;

import com.spring.aop.before.service.HelloService;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description impl
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void greet(String name) {
        System.out.println("greeting ..." + name);
    }

    @Override
    public void service(String name) {
        System.out.println("servicing ..." + name);
    }
}
