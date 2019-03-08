package com.spring.ioc.resourceload;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.Assert;

import java.io.IOException;


/**
 * 资源导入/加载：spring 为不同的资源提供了不同的资源加载实现类，而且可以隐式的标识资源(通过前缀识别)
 * classpath:/和classpath: 从类路径（类的根目录）加载
 * file：... URLResource从文件系统目录加载资源，可以使用绝对路径，也可是相对路径
 * http://... 从web服务器加载资源
 * ftp://... 从ftp服务器加载资源
 * <p>
 * 其中classpath：的另一种方式是classpath*：假设有多个jar包或者文件系统路径都拥有一个相同的包名com.riane,"classpath:"只会在第一个
 * 加载的com.riane包的类路径下查找资源，而“classpath*:”则会扫描所有的这个jar包以及类路径下出现的com.riane类路径
 * <p>
 * 支持Ant风格的3种通配符;
 * ? : 表示匹配文件中的一个字符
 * * : 表示匹配任意字符
 * ** : 表示多层路径匹配
 * <p>
 * <p>
 * {@linkplain ResourceLoader}
 */
public class ResourceLoadDemo {

    public static void main(String[] args) throws IOException {

        /**
         * ResourceLoader的实现类很多，其中getResources()方法可以根据路径加载资源文件，
         * 但是支持Ant风格的只有ResourcePatternResolver类，它的getResources(location)参数支持Ant风格
         * 其他的实现类
         */
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = patternResolver.getResources("classpath*:/resource/*.txt");
        Assert.notNull(resources, "未找到先关txt结尾的文件");
        for (Resource resource : resources) {
            System.out.println(resource.getFilename());
        }

    }
}
