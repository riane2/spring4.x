package com.java.reflect;

import com.java.reflect.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {

    public static void main(String[] args) throws Exception {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();


        System.out.println("load:" + loader.getClass());
        System.out.println("parent load:" + loader.getParent());
        //根加载器在Java中访问不到，因此为null
        System.out.println("grandparent load :" + loader.getParent().getParent());

        Class<?> aClass = loader.loadClass("com.java.reflect.bean.User");
        User user1 = (User) aClass.newInstance();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());
            /**
             * private，protected 属性必须加field.setAccessible(true)取消Java语言检查之后才能进行赋值操作
             */
            field.setAccessible(true);
            field.set(user1, "user1-name");
        }
        System.out.println(user1.getName());
        System.out.println("*********************************************");
        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class);
        User riane = (User) constructor.newInstance("riane3");
        System.out.println(riane.getName());

        //获取默认的无参构造器的方法1，另一种方法时getDeclaredConstructor();不用传入任何参数
        Constructor<?> noCons = aClass.getDeclaredConstructor((Class[]) null);
        User user = (User) noCons.newInstance();
        System.out.println(user.getName());

        /**
         * 所有带Declared的表示所有构造方法，不包括继承的方法，
         * 不带的表示公共的构造方法不带的表示公共的构造方法
         */
        Method setName = aClass.getMethod("setName", String.class);

        /**
         * private，protected方法必须加method.setAccessible(true)取消Java语言检查之后才能执行方法
         */
        setName.invoke(user, "riane2");
        System.out.println(user.getName());

        Method print = aClass.getDeclaredMethod("print");
        print.invoke(user);
    }
}
