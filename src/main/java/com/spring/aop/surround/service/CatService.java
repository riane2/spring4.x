package com.spring.aop.surround.service;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description cat service
 */
public interface CatService {
    void eat(String catName, String eatThings);

    int getAge(int originalAge);
}
