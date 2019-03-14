package com.spring.ioc.propertyeditor;

import com.spring.ioc.propertyeditor.bean.Dog;

import java.beans.PropertyEditorSupport;

/**
 * 自定义的属性编辑器
 */
public class MyDogPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] split = text.split(",");
        Dog dog = new Dog();
        dog.setName(split[0]);
        dog.setType(split[1]);
        setValue(dog);
    }
}
