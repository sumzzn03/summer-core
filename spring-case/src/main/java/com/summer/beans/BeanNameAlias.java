package com.summer.beans;

import com.summer.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示设置 Bean 的别名
 */
public class BeanNameAlias {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definition-context.xml");
        User user = beanFactory.getBean("user", User.class);
        User userAlias = beanFactory.getBean("xiaoxiong-user", User.class);
        System.out.println(user == userAlias);
    }
}
