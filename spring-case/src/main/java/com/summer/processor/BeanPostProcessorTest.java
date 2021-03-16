package com.summer.processor;

import com.alibaba.fastjson.JSON;
import com.summer.domain.Car;
import com.summer.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BeanPostProcessor 测试类
 * @author zhangui
 */
@Slf4j
public class BeanPostProcessorTest {
    public static void main(String[] args) {
        beanPostProcessorRun();
        beanFactoryPostProcessorRun();
    }

    /**
     * Bean 处理器
     */
    public static void beanPostProcessorRun() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/bean-processor-context.xml");
        User user = applicationContext.getBean(User.class);
        log.info("user:{}", JSON.toJSONString(user));
    }

    /**
     * BeanFactory 处理器
     */
    public static void beanFactoryPostProcessorRun() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/bean-processor-context.xml");
        Car car = applicationContext.getBean(Car.class);
        log.info("car:{}", JSON.toJSONString(car));
    }
}
