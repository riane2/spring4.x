package com.java.proxy;

import com.java.proxy.handle.PerformHandle;
import com.java.proxy.service.ForumService;
import com.java.proxy.service.ParentForum;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理有两种：JDK代理和CGlib动态代理
 * 其中JDK只支持接口代理，不支持类代理
 * <p>
 * jDK动态代理设涉及两个类：{@linkplain Proxy} 和 {@linkplain InvocationHandler}
 *
 * @author lixiongxiong
 * @date 2019/3/17
 * @description proxy
 */
public class ProxyDemo {

    public static void main(String[] args) {
        ParentForum target = new ForumService();
        PerformHandle handle = new PerformHandle(target);
        /**
         * 代理创建的几种方式：
         * 注意：强转一定是转成接口类对象，不是实现类对象
         * newProxyInstance的三个入参分别表示：类加载器，需要代理的接口类class文件，以及InvocationHandler实现类
         */
        //(ParentForum) Proxy.newProxyInstance(ParentForum.class.getClassLoader(), new Class[]{ParentForum.class}, handle);
        //(ParentForum) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handle);
        ParentForum proxyInstance = (ParentForum) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handle);

        proxyInstance.removeForum(100);
        proxyInstance.removeTopic(1024);
    }
}
