package com.summer.beans.initialization;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 使用 配置类进行启动
 */
public class ApplicationStartDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationDemo.class);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car.toString());
    }
}
