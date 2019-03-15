package com.spring.ioc.placeholder.enctypt.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BookExt {

    @Value("#{book.name}")
    private String nameExt;

    public String getNameExt() {
        return nameExt;
    }

    public void setNameExt(String nameExt) {
        this.nameExt = nameExt;
    }
}
