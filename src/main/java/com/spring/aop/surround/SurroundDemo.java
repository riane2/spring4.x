package com.spring.aop.surround;

import com.spring.aop.surround.config.MyConfig;
import com.spring.aop.surround.service.CatService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 环绕增强：方法前后都加
 * <p>
 * 这个实例用注解实现
 *
 * @author lixiongxiong
 * @date 2019/3/17
 * @description surround advice
 */
public class SurroundDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        CatService catService = context.getBean(CatService.class);
        if (catService != null) {
            catService.eat("riane", "老鼠");
            int age = catService.getAge(8);
            System.out.println(age);
        }
    }
}
