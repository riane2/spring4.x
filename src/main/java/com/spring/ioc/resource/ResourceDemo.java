package com.spring.ioc.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * {@link Resource}:实现类：实现和资源的导入，比Java自带的file等好用
 */
public class ResourceDemo {

    public static void main(String[] args) throws Exception {

        FileSystemResource fileSystemResource = new
                FileSystemResource("E:\\StudyCodes\\Spring\\springall\\src\\main\\resources\\resource\\hello world.txt");

        ClassPathResource classPathResource = new ClassPathResource("resource/hello world.txt");

        OutputStream outputStream = fileSystemResource.getOutputStream();
        outputStream.write(" riane".getBytes());
        outputStream.close();

        InputStream fileInputStream = fileSystemResource.getInputStream();
        InputStream resourceInputStream = classPathResource.getInputStream();


        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        int i;
        while ((i = fileInputStream.read()) != -1) {
            byteArray.write(i);
        }
        System.out.println(byteArray.toString());

        byteArray.close();

        byteArray = new ByteArrayOutputStream();
        int j;
        while ((j = resourceInputStream.read()) != -1) {
            byteArray.write(j);
        }

        System.out.println(byteArray.toString());

        byteArray.close();
        fileInputStream.close();
        resourceInputStream.close();


    }
}
