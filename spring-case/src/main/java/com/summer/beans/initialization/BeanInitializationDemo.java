package com.summer.beans.initialization;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 演示 Bean 的初始化方式
 */
public class BeanInitializationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Config.class);
        applicationContext.refresh();
        System.out.println("Spring 应用上下文已经启动");
        System.out.println("Spring 应用上下文准备关闭");
        applicationContext.close();
        System.out.println("Spring 应用上下文已经关闭");
    }

    @Configuration
    public static class Config {

        @Bean(initMethod = "initCar", destroyMethod = "destroyCar")
        public Car car() {
            return new Car();
        }
    }
}
