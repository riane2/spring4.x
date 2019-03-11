package com.spring.ioc.factorybean;

import com.spring.ioc.beanfactory.bean.Car;
import org.springframework.beans.factory.FactoryBean;

public class FactoryBeanDemo implements FactoryBean<Car> {

    private String carInfo;

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    public String getCarInfo() {
        return carInfo;
    }

    /**
     * context.getBean()接口实际会调用此处
     *
     * @return
     * @throws Exception
     */
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] split = carInfo.split(",");
        car.setName(split[0]);
        car.setPrice(Float.parseFloat(split[1]));
        return car;
    }

    public Class<?> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
