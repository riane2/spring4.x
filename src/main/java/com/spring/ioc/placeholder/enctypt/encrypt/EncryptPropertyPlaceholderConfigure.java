package com.spring.ioc.placeholder.enctypt.encrypt;

import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * 可以对属性进行加密和解密的PropertyPlaceholderConfigure
 */
public class EncryptPropertyPlaceholderConfigure extends PropertyPlaceholderConfigurer {

    private List<String> encryptFields = Arrays.asList("book.name", "book.password");

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (encryptFields.contains(propertyName)) {
            return convertEncryptPropertyValue(propertyValue);
        }
        return convertPropertyValue(propertyValue);
    }


    /**
     * 自定义解密方法
     *
     * @param originalValue
     * @return
     */
    private String convertEncryptPropertyValue(String originalValue) {

        byte[] encoded = {56, -85, 41, 32, 42, -57, -26, -56, -74, -8, -14, 38, 93, -123, -88, 13, -29, 61, -23, -42, 8, -39, 67, 100};

        SymmetricCrypto crypto = new SymmetricCrypto(SymmetricAlgorithm.DESede, encoded);

        return crypto.decryptStrFromBase64(originalValue);
    }
}
