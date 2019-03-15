package com.spring.ioc.i18n.spring;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * {@linkplain ReloadableResourceBundleMessageSource}
 * ，  在不重启应用的前提下实现属性的变更
 */
@Configuration
public class ReloadMessageSourceDemo {


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("rel_res_bundle_msg_source");
        //TODO 设置每5S刷新一次
        messageSource.setCacheSeconds(5);
        return messageSource;
    }


    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ReloadMessageSourceDemo.class);
        Object[] params = {"riane", "Kyrie", new GregorianCalendar().getTime()};
        /**
         * //TODO 因为ApplicationContext也实现了MessageSource接口，
         * 但是如果要使用applicationContext.getMessage方法，必须在容器中注册一个名为“messageSource”的MessageSource实现类，否则
         * 容器默认是的DelegatingMessageSource实现类，就会出现问题
         */
        System.err.println(applicationContext.getMessage("my.info", params, Locale.CHINA));
        ReloadableResourceBundleMessageSource messageSource = applicationContext.getBean(ReloadableResourceBundleMessageSource.class);
        if (messageSource != null) {
            for (int i = 0; i < 2; i++) {
                String myInfo = messageSource.getMessage("my.info", params, Locale.CHINA);
                String myMsg = messageSource.getMessage("my.msg", params, Locale.CHINA);
                System.out.println(myInfo);
                System.out.println(myMsg);
                /**
                 * IDEA测试时，修改后需要用ctr+F9才能看到效果。其他工具保存文件后就能看到效果
                 */
                Thread.currentThread().sleep(20000);
            }
        }

    }
}
