package com.spring.ioc.placeholder.enctypt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import com.spring.ioc.placeholder.enctypt.config.*;

import com.spring.ioc.placeholder.enctypt.bean.*;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        /*byte[] encoded = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();
        System.out.println(Arrays.toString(encoded));

        byte[] encodeds = {56, -85, 41, 32, 42, -57, -26, -56, -74, -8, -14, 38, 93, -123, -88, 13, -29, 61, -23, -42, 8, -39, 67, 100};

        SymmetricCrypto crypto = new SymmetricCrypto(SymmetricAlgorithm.DESede, encodeds);

        System.out.println(crypto.encryptBase64("Java 8 Stream"));

        System.out.println(crypto.encryptBase64("123456789java"));

        String name = "encrypt-U+gwYroBUZf6XgvkAH0TgA==";

        System.out.println(name.indexOf("encrypt-"));*/
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyEncryptConfigrue.class);


        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        Object book = applicationContext.getBean("book", Book.class);
        System.out.println(book);
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));

    }
}
