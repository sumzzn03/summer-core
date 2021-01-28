package am.zzz.beans.defination;

import am.zzz.dependency.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;
import sun.security.krb5.Config;

public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        registerUserBeanDefinition(applicationContext, "xiaoxiong-user");
        registerUserBeanDefinition(applicationContext);
        applicationContext.refresh();
        System.out.println(applicationContext.getBeansOfType(User.class));
        applicationContext.close();
    }

    /**
     * 以命名方式注册 BeanDefinition
     *
     * @param registry
     * @param beanName
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder
                .addPropertyValue("id", 1L)
                .addPropertyValue("name","小熊");
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        if(StringUtils.hasText(beanName)) {
            // 通过命名方式注册 BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinition);
        } else {
            // 通过非命名方式注册 BeanDefinition
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
        }
    }

    /**
     * 以非命名方式注册 BeanDefinition
     *
     * @param registry
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }
}
