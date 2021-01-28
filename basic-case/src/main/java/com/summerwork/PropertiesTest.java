package com.summerwork;

import java.util.Properties;

/**
 * Properties 类测试
 *
 * @author sam
 * @version 1.0
 * @since 2020-08-06
 */
public class PropertiesTest {
    public static void main(String[] args) throws Exception {
        // System 可以得到系统的 Properties
        Properties properties = System.getProperties();
        properties.list(System.out);


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
