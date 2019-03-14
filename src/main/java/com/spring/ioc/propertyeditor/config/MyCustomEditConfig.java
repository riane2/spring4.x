package com.spring.ioc.propertyeditor.config;

import com.spring.ioc.propertyeditor.MyDogPropertyEditor;
import com.spring.ioc.propertyeditor.bean.Dog;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ImportResource("demo.xml")
public class MyCustomEditConfig {


    /**
     * 自定义属性编辑器的配置类，属于BeanFactoryPostProcessor的子类
     *
     * @return
     */
    //@Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer editorConfigurer = new CustomEditorConfigurer();
        Map<Class<?>, Class<? extends PropertyEditor>> map = new HashMap<>();
        map.put(Dog.class, MyDogPropertyEditor.class);
        editorConfigurer.setCustomEditors(map);
        return editorConfigurer;
    }

}
