package com.summer.environment;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertyResolver;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.core.io.support.ResourcePropertySource;

import java.util.Map;

/**
 * PropertyResolver 测试
 */
@Slf4j
public class PropertyResolverTest {
    public static void main(String[] args) throws Exception {
        ResourcePropertySource resourcePropertySource = new ResourcePropertySource("222", "classpath:resourceProperty.properties");
        MutablePropertySources sources = new MutablePropertySources();
        sources.addFirst(resourcePropertySource);
        PropertyResolver propertyResolver = new PropertySourcesPropertyResolver(sources);
        String name = propertyResolver.getProperty("name");
        String text = propertyResolver.resolvePlaceholders("name is ${name}");
        log.info("{}, {}", JSON.toJSONString(name), text);
    }

    /**
     * MapPropertySource 可以用来存储一个 Map
     */
    public static void testPropertyResolver() {

    }
}
