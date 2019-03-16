package com.spring.ioc.eventpublis.listerner;

import com.spring.ioc.eventpublis.event.EventDemo;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.xml.transform.Source;

/**
 * {@linkplain ApplicationListener}事件监听
 */
@Component
public class ListernerDemo implements ApplicationListener<EventDemo> {

    @Override
    public void onApplicationEvent(EventDemo event) {
        System.out.println("收到EventDemo事件：" + event.toString());
    }
}
