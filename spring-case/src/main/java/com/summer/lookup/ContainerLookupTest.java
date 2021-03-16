package com.summer.lookup;

import com.alibaba.fastjson.JSON;
import com.summer.annotated.UserAnno;
import com.summer.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找
 *
 * 通过 "名称" 依赖查找的两种方式：
 * 1. 实时查找
 * 2. 延时查找
 *
 * 通过类型进行依赖查找：
 * 1. 单个对象
 * 2. 集合对象
 *
 * 通过注解进行依赖查找
 */
@Slf4j
public class ContainerLookupTest {

    /**
     * 容器内的依赖查找
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/lookup-context.xml");
        lookupByBeanName(applicationContext);
        lookupByBeanType(applicationContext);
        lookupByBeanNameAndType(applicationContext);

        lookupByCollectionType(applicationContext);
        lookupByAnnotation(applicationContext);
        lookupInLazy(applicationContext);
    }

    /**
     * 根据 bean 的名称进行查找：BeanFactory#getBean(String name)
     *
     * @param applicationContext
     */
    private static void lookupByBeanName(ApplicationContext applicationContext) {
        log.info("通过名称查找 bean: {}", JSON.toJSONString(applicationContext.getBean("user")));
    }

    /**
     * 根据 bean 的类型进行查找：BeanFactory#getBean(Class<T> requiredType)
     *
     * @param applicationContext
     */
    private static void lookupByBeanType(ApplicationContext applicationContext) {
        log.info("通过类型查找 bean: {}", JSON.toJSONString(applicationContext.getBean(User.class)));
    }

    /**
     * 同时根据 bean 的名称、类型进行查找：BeanFactory#getBean(String name, Class<T> requiredType)
     *
     * @param applicationContext
     */
    private static void lookupByBeanNameAndType(ApplicationContext applicationContext) {
        log.info("通过类型查找 bean: {}", JSON.toJSONString(applicationContext.getBean("user", User.class)));
    }

    /**
     * 根据 bean 的类型进行查找集合：ListableBeanFactory#getBeansOfType(Class<T> type)
     *
     * @param applicationContext
     */
    private static void lookupByCollectionType(ApplicationContext applicationContext) {
        Map<String, User> beanMap = applicationContext.getBeansOfType(User.class);
        log.info("通过类型获取集合 bean: {}", JSON.toJSONString(beanMap));
    }

    /**
     * 根据注解来查找 bean 对象：ListableBeanFactory#getBeansWithAnnotation(Class<? extends Annotation> annotationType)
     *
     * @param applicationContext
     */
    private static void lookupByAnnotation(ApplicationContext applicationContext) {
        Map<String, Object> beanMap = applicationContext.getBeansWithAnnotation(UserAnno.class);
        log.info("通过注解查找 bean: {}", JSON.toJSONString(beanMap));
    }

    /**
     * 延时查找
     *
     * @param applicationContext
     */
    private static void lookupInLazy(ApplicationContext applicationContext) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>)applicationContext.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延时查找：" + user);
    }
}
