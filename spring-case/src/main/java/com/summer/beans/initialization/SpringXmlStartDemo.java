package com.summer.beans.initialization;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用 配置类进行启动
 */
public class SpringXmlStartDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-xml-context.xml");
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person.getCarName());
        System.out.println(person.getCar().getName());
    }
}
