package com.spring.aop.before;

import com.spring.aop.before.methodbefore.MyMethodBefore;
import com.spring.aop.before.service.HelloService;
import com.spring.aop.before.service.impl.HelloServiceImpl;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description before aop
 */
public class BeforeDemo {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        MyMethodBefore methodBefore = new MyMethodBefore();

        /**
         * 代理工厂类
         * 还可以使用{@linkplain ProxyFactoryBean}实现Java配置的实现
         */
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(helloService);
        proxyFactory.addAdvice(methodBefore);
        //优化代理用：Cglib2AopProxy
        proxyFactory.setOptimize(true);

        HelloService proxy = (HelloService) proxyFactory.getProxy();
        proxy.greet("riane");
        proxy.service("riane");
    }
}
