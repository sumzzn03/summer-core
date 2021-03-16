package com.summer.annotated;

import com.alibaba.fastjson.JSON;
import com.summer.annotated.config.AnnotatedConfiguration;
import com.summer.annotated.config.ImportConfig;
import com.summer.domain.Phone;
import com.summer.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 注解启动
 * @author zhanghui
 */
@Slf4j
public class AnnotatedConfigApplicationStart {
    public static void main(String[] args) {
        defaultRun();
        configClassRun();
        packageRun();
        dependencyRun();
        importXmlRun();
    }

    /**
     * 手动方式启动
     */
    public static void defaultRun() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 扫描 or 注册
        applicationContext.register(AnnotatedConfiguration.class);
        // applicationContext.scan("com.summer.annotated.config");
        applicationContext.refresh();
        User user = applicationContext.getBean(User.class);
        log.info(JSON.toJSONString(user));
    }

    /**
     * 一般启动方式
     */
    public static void configClassRun() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotatedConfiguration.class);
        User user = applicationContext.getBean(User.class);
        log.info(JSON.toJSONString(user));
    }

    /**
     * 包路径启动方式
     */
    public static void packageRun() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.summer.annotated.config");
        User user = applicationContext.getBean(User.class);
        log.info(JSON.toJSONString(user));
    }

    /**
     * 获取依赖
     */
    public static void dependencyRun() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotatedConfiguration.class);
        User user = applicationContext.getBean(User.class);
        log.info(JSON.toJSONString(user.getCar()));
    }

    /**
     * 获取 xml 中的 bean
     */
    public static void importXmlRun() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportConfig.class);
        Phone phone = applicationContext.getBean(Phone.class);
        log.info(JSON.toJSONString(phone));
    }
}
