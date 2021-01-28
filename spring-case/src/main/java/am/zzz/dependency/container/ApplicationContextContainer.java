package am.zzz.dependency.container;

import am.zzz.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 使用 ApplicationContext 作为 IoC 容器
 */
@Configuration
public class ApplicationContextContainer {

    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("小熊");
        return user;
    }

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类作为配置类，注册到容器中
        applicationContext.register(ApplicationContextContainer.class);
        // 启动应用上下文
        applicationContext.refresh();
        // 进行依赖查找 集合对象
        lookupByCollectionType(applicationContext);
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beanMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("通过类型获取的集合对象：" + beanMap);
        }
    }
}
