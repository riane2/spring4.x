package com.spring.ioc.eventpublis.publisher;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.ResolvableType;

/**
 * {@linkplain ApplicationEventMulticaster}事件广播器
 * <p>
 * 容器默认广播器是：{@linkplain SimpleApplicationEventMulticaster}
 * 可以自定义容器的事件广播器
 */
public class MyEventMulticaster implements ApplicationEventMulticaster {
    public void addApplicationListener(ApplicationListener<?> listener) {

    }

    public void addApplicationListenerBean(String listenerBeanName) {

    }

    public void removeApplicationListener(ApplicationListener<?> listener) {

    }

    public void removeApplicationListenerBean(String listenerBeanName) {

    }

    public void removeAllListeners() {

    }

    public void multicastEvent(ApplicationEvent event) {

    }

    public void multicastEvent(ApplicationEvent event, ResolvableType eventType) {

    }
}
