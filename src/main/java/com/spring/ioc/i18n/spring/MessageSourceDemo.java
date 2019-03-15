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
 * {@linkplain MessageSource}: Spring 提供的访问国际化信息的接口
 * 方法：1、getMessage(String code, @Nullable Object[] args, @Nullable String defaultMessage, Locale locale)
 * code表示：property文件中的属性名
 * args表示：占位符填充对象
 * defaultMessage:表示未找到时的默认返回对象
 * locale：表示本地化对象
 * 2、getMessage(MessageSourceResolvable resolvable, Locale locale)
 * 将code，args，defaultMessage封装成一个MessageSourceResolvable对象
 * <p>
 * <p>
 * <p>
 * 常用的两个实现类：
 * {@linkplain ResourceBundleMessageSource}
 * {@linkplain ReloadableResourceBundleMessageSource}
 * 都是基于JDK的ResourceBundle实现的，不同点在于第二个可以实现定时刷新，即在不重启应用的前提下实现属性的变更
 */
@Configuration
public class MessageSourceDemo {


    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("res_bundle_msg_source");
        return messageSource;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MessageSourceDemo.class);
        Object[] params = {"riane", "Kyrie", new GregorianCalendar().getTime()};
        ResourceBundleMessageSource messageSource = applicationContext.getBean(ResourceBundleMessageSource.class);
        if (messageSource != null) {
            /**
             * 和ResourceBundle的区别在于不用显示的利用MessageFormat进行占位符的转换
             * 而且只需要指定文件名，无需分别加载不同的语言，不同本地化对象就可以实现对象转换
             */
            String myInfo = messageSource.getMessage("my.info", params, Locale.CHINA);

            /**
             * 根据Locale.US加载res_bundle_msg_source_en_US.properties文件中的属性
             */
            String myMsg = messageSource.getMessage("my.msg", params, Locale.US);
            System.out.println(myInfo);
            System.out.println(myMsg);
        }

    }
}
