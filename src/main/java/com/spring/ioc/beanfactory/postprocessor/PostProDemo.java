package com.spring.ioc.beanfactory.postprocessor;

import com.spring.ioc.beanfactory.bean.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author lixiongxiong
 * @date 2019/3/10
 * @description post processor
 */
@Component
public class PostProDemo implements BeanPostProcessor, Ordered {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Car) {
            ((Car) bean).setName("AuDi");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * 实现ordered接口，实现多个后置处理器的顺序访问执行
     *
     * @return
     */
    public int getOrder() {
        return 10;
    }
}
