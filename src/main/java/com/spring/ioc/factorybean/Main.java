package com.spring.ioc.factorybean;

import com.spring.ioc.beanfactory.bean.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("factory-bean-demo.xml");
        /**
         *
         */
        Object car = context.getBean("factory-bean-car");
        if (car != null && car instanceof Car) {
            System.out.println(car);
        }

        /**
         * 调用本体对象，需要在beanName前面加上&符号即可
         */
        FactoryBeanDemo demo = (FactoryBeanDemo) context.getBean("&factory-bean-car");
        if (demo != null) {
            System.out.println(demo.getCarInfo());
        }


    }
}
