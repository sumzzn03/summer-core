package com.summer.beans;

import com.summer.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * 通过 BeanDefinitionBuilder 或 AbstractBeanDefinition 构建 BeanDefinition 实例
 *
 * BeanDefinition 并非是 Bean 的终态
 */
public class BeanDefinitionDemo {
    public static void main(String[] args) {
        // 1. 通过 BeanDefinitionBuilder 创建 BeanDefinition
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 设置 BeanDefinition 属性
        builder.addPropertyValue("id", 1L);
        builder.addPropertyValue("name", "小熊");
        // 获取 BeanDefinition 实例
        BeanDefinition beanDefinition = builder.getBeanDefinition();

        // 2. 通过 AbstractBeanDefinition 创建 BeanDefinition
        GenericBeanDefinition generic = new GenericBeanDefinition();
        // 设置 Bean 的类型
        generic.setBeanClass(User.class);
        MutablePropertyValues values = new MutablePropertyValues();
//        values.addPropertyValue("id", 1L);
//        values.addPropertyValue("name", "小马哥");
        values.add("id", 1L).add("name", "小马哥");
        generic.setPropertyValues(values);
    }
}
