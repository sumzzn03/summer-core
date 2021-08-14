package com.summer.environment;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.*;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class EnvironmentTest {
    public static void main(String[] args) throws Exception {
        Environment env = new StandardEnvironment();
        // 1. 操作系统的环境变量
        Map<String, Object> systemEnvironment = ((StandardEnvironment) env).getSystemEnvironment();
        log.info(JSON.toJSONString(systemEnvironment));

        // 2. JVM 属性配置
        Map<String, Object> systemProperties = ((StandardEnvironment) env).getSystemProperties();
        log.info(JSON.toJSONString(systemProperties));

        // 3. 属性
//        Assert.assertEquals("UTF-8", env.getProperty("file.encoding"));
//        Assert.assertTrue(env.containsProperty("file.encoding"));
//
//        // 4. 剖面 spring.profiles.default(默认为 default) spring.profiles.active
//        //    只要有一个返回 true acceptsProfiles 方法就返回 true，!a 为不包含该 profiles
//        Assert.assertTrue(env.acceptsProfiles("default"));
//        Assert.assertTrue(env.acceptsProfiles("a", "default"));
//        Assert.assertFalse(env.acceptsProfiles("a"));
//        Assert.assertTrue(env.acceptsProfiles("!a", "b"));

        propertySourceRun();
        propertyResolverRun();
    }

    /**
     * PropertySource
     *
     * 1. MapPropertySource
     * 2. ResourcePropertySource
     * 3. StubPropertySource  用于占位用
     * 4. ComparisonPropertySource 用于集合排序，不允许获取属性值
     * @throws Exception
     */
    public static void propertySourceRun() throws Exception {
        PropertySource mapPropertySource = new MapPropertySource("map", Collections.singletonMap("key", "source1"));
        log.info("result{}", Objects.equals("value1", mapPropertySource.getProperty("key")));

        ResourcePropertySource resourcePropertySource = new ResourcePropertySource("resource", "classpath:resources.properties");
        log.info("result{}", Objects.equals("value2", resourcePropertySource.getProperty("key")));

        PropertySource propertySource1 = new MapPropertySource("source1", Collections.singletonMap("key", "value1"));
        PropertySource propertySource2 = new MapPropertySource("source2", Collections.singletonMap("key", "value2"));

        CompositePropertySource compositePropertySource = new CompositePropertySource("composite");
        compositePropertySource.addPropertySource(propertySource1);
        compositePropertySource.addPropertySource(propertySource2);
        log.info("result{}", Objects.equals("value1", compositePropertySource.getProperty("key")));
    }

    /**
     * PropertyResolver
     * @throws Exception
     */
    public static void propertyResolverRun() throws Exception {
        PropertySource mapPropertySource = new MapPropertySource("map",
                Collections.singletonMap("key", "source1"));
        log.info("result{}", Objects.equals("value1", mapPropertySource.getProperty("key")));

        ResourcePropertySource resourcePropertySource = new ResourcePropertySource(
                "resource", "classpath:resources.properties");
        log.info("result{}", Objects.equals("value2", resourcePropertySource.getProperty("key")));
    }

    public static void environmentTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(EnvironmentConfig.class);

        Environment environment = context.getEnvironment();
        String[] activeProfiles = environment.getActiveProfiles();
        String[] defaultProfiles = environment.getDefaultProfiles();

//        System.out.println(ArrayUtils.toString(activeProfiles));
//        System.out.println(ArrayUtils.toString(defaultProfiles));
//        System.out.println(context.getBean("person"));
    }
}
