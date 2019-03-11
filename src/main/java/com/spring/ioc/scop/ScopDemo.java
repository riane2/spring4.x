package com.spring.ioc.scop;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.beans.factory.config.Scope;

/**
 * 自定义Scope：
 * 1、实现{@linkplain Scope}接口
 * 2、{@linkplain CustomScopeConfigurer}这个BeanFactoryPostProcessor的后置处理器注册自定义的Bean作用于
 */
@org.springframework.context.annotation.Scope
public class ScopDemo {

}
