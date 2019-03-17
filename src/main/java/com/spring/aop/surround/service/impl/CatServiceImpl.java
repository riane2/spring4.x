package com.spring.aop.surround.service.impl;

import com.spring.aop.surround.service.CatService;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description cat service impl
 */
public class CatServiceImpl implements CatService {
    @Override
    public void eat(String catName, String eatThings) {
        System.out.println("My name is " + catName + ", I like eat " + eatThings);
    }

    @Override
    public int getAge(int originalAge) {
        return originalAge * 7;
    }
}
