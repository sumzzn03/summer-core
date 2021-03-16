package com.summer.dependency.container;

import com.summer.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * 使用 BeanFactory 作为 IoC 容器
 */
public class BeanFactoryContainer {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // xml 配置文件 classpath 路径
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载配置
        int beanCount = reader.loadBeanDefinitions(location);
        System.out.println("BeanDefinitionDemo 加载的数量：" + beanCount);
        // 进行依赖查找 集合对象
        lookupByCollectionType(beanFactory);
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beanMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("通过类型获取的集合对象：" + beanMap);
        }
    }
}
