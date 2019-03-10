package com.spring.ioc.beanfactory.bean;

/**
 * @author lixiongxiong
 * @date 2019/3/10
 * @description car
 */
public class Car {

    private String name;

    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
