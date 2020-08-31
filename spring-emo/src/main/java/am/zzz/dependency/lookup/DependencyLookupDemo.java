package am.zzz.dependency.lookup;

import am.zzz.dependency.annotation.Super;
import am.zzz.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
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
public class DependencyLookupDemo {

    public static void main(String[] args) {
        // 配置 xml 文件
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META_INF/dependency-lookup-context.xml");
        lookupInRealTime(beanFactory);
        lookupInLazy(beanFactory);
        lookupByType(beanFactory);
        lookupByCollectionType(beanFactory);
        lookupByAnnotation(beanFactory);
    }

    /**
     * 实时查找
     * @param beanFactory
     */
    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User)beanFactory.getBean("user");
        System.out.println(user);
        System.out.println("实时查找：" + user);
    }

    /**
     * 延时查找
     * @param beanFactory
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>)beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延时查找：" + user);
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("通过类型查找：" + user);
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beanMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("通过类型获取的集合对象：" + beanMap);
        }
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beanMap = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("标注 @Super 注解的集合对象：" + beanMap);
        }
    }
}
