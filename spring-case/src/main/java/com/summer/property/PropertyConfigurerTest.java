package com.summer.property;

import com.alibaba.fastjson.JSON;
import com.summer.domain.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 属性设置测试类
 * @author zhangui
 */
@Slf4j
public class PropertyConfigurerTest {
    public static void main(String[] args) {
        placeholderConfigurerRun();
        overrideConfigurerRun();
    }

    /**
     * 占位符替换配置
     */
    public static void placeholderConfigurerRun() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/property-configurer-context.xml");
        DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
        log.info("dataSource:{}", JSON.toJSONString(dataSource));
    }

    /**
     * 替换 bean 的属性
     */
    public static void overrideConfigurerRun() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/property-configurer-context.xml");
        DataSource dataSource = applicationContext.getBean("dataSourceOverride", DataSource.class);
        log.info("dataSource:{}", JSON.toJSONString(dataSource));
    }
}
