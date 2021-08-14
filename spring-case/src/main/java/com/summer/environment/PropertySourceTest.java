package com.summer.environment;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.util.Map;

/**
 * PropertySource 测试
 */
@Slf4j
public class PropertySourceTest {
    public static void main(String[] args) throws Exception {
        testMapPropertySource();
        testResourcePropertySource();
    }

    /**
     * MapPropertySource 可以用来存储一个 Map
     */
    public static void testMapPropertySource() {
        Map<String, Object> propertyMap = Maps.newHashMap();
        propertyMap.put("name", "xiaoming");
        propertyMap.put("age", "23");
        MapPropertySource propertySource = new MapPropertySource("12345", propertyMap);

        String propertySourceName = propertySource.getName();
        Object name = propertySource.getProperty("name");
        String[] propertyNames = propertySource.getPropertyNames();
        boolean isContains = propertySource.containsProperty("age");

        log.info("{}, {}, {}, {}", propertySourceName, JSON.toJSONString(name), JSON.toJSONString(propertyNames), isContains);
    }

    /**
     * ResourcePropertySource 可以用来存储一个 properties 文件内容
     */
    public static void testResourcePropertySource() throws Exception {
        ResourcePropertySource resourcePropertySource = new ResourcePropertySource("222", "classpath:resourceProperty.properties");

        String propertySourceName = resourcePropertySource.getName();
        Object name = resourcePropertySource.getProperty("name");
        String[] propertyNames = resourcePropertySource.getPropertyNames();
        boolean isContains = resourcePropertySource.containsProperty("age");

        log.info("{}, {}, {}, {}", propertySourceName, JSON.toJSONString(name), JSON.toJSONString(propertyNames), isContains);
    }
}
