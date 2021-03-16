package com.summer.beans.lazy;

import com.summer.beans.initialization.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

public class BeanLazyDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Config.class);
        applicationContext.refresh();
        System.out.println("Spring 应用上下文已经启动");
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);
        applicationContext.close();
    }

    @Configuration
    public static class Config {

        @Bean
        @Lazy
        public Car car() {
            return new Car();
        }
    }
}
