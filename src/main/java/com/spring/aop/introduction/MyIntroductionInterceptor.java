package com.spring.aop.introduction;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description introduction interceptor
 */
@Component
public class MyIntroductionInterceptor extends DelegatingIntroductionInterceptor implements MyCatEnabled {

    private ThreadLocal<Boolean> ENABLED = new ThreadLocal<>();

    @Override
    public void setEnabled(boolean isEnabled) {
        ENABLED.set(isEnabled);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if (ENABLED != null && ENABLED.get() != null && ENABLED.get()) {
            System.out.println("引介增强成功");
        }
        return super.invoke(mi);
    }
}
