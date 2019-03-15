package com.spring.ioc.eventpublis.listerner;

import com.spring.ioc.eventpublis.event.EventDemo;
import org.springframework.context.ApplicationListener;

/**
 * {@linkplain ApplicationListener}事件监听
 */
public class ListernerDemo implements ApplicationListener<EventDemo>{

    @Override
    public void onApplicationEvent(EventDemo event) {

    }
}
