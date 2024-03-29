package com.summer.properties;


import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * Properties 类测试
 *
 * @author sam
 * @version 1.0
 * @since 2020-08-06
 */
@Slf4j
public class PropertiesTest {
    public static void main(String[] args) throws Exception {
        // System 可以得到系统的 Properties
        Properties properties = System.getProperties();
        properties.list(System.out);

        // System 获取 environment
        log.info("env{}", System.getenv());


        // 自定义 Properties
        PropertiesTest test = new PropertiesTest();
        test.hello();

    }

    /**
     * 自定义 Properties
     *
     * @throws Exception
     */
    public void hello() throws Exception {
        Properties defaultProperties = new Properties();
        defaultProperties.load(this.getClass().getResourceAsStream("/example.properties"));
        System.out.println(defaultProperties.get("name"));
        System.out.println(defaultProperties.get("age"));
    }
}
