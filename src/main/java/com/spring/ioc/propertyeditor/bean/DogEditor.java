package com.spring.ioc.propertyeditor.bean;

import java.beans.PropertyEditorSupport;

/**
 * 自定义的属性编辑器
 * <p>
 * JavaBean规范：JavaBean的设施会在JavaBean的相同类包下查找是否存在<JavaBean>Editor的规范类，
 * 如果存在，则自动使用该类作为JavaBean的属性编辑器。
 * 如此，则无需通过CustomEditorConfigure注册了
 */
public class DogEditor extends PropertyEditorSupport {

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
