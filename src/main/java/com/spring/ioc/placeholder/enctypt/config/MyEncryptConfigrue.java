package com.spring.ioc.placeholder.enctypt.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import com.spring.ioc.placeholder.enctypt.encrypt.*;

@Configuration
@ComponentScan("com.spring.ioc.placeholder.enctypt")
public class MyEncryptConfigrue {

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        EncryptPropertyPlaceholderConfigure placeholderConfigure = new EncryptPropertyPlaceholderConfigure();
        placeholderConfigure.setLocation(new ClassPathResource("book-encrypt.properties"));
        return placeholderConfigure;
    }

}
