package com.spring.ioc.eventpublis.event;

import org.springframework.context.ApplicationEvent;

import java.util.EventListener;
import java.util.EventObject;

/**
 * java的事件和监听器：{@linkplain EventObject}和{@linkplain EventListener}
 * {@linkplain ApplicationEvent}:继承EventObject类
 */
public class EventDemo extends ApplicationEvent {

    private long value;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public EventDemo(Object source, long value) {
        super(source);
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
