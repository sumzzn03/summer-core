package am.zzz.dependency.injection;

import am.zzz.dependency.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // 配置 xml 文件
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META_INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
//        System.out.println(userRepository.getUserList());

        System.out.println(userRepository.getBeanFactory());
        System.out.println(beanFactory);
        System.out.println(userRepository.getBeanFactory() == beanFactory);
        System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory userFactory = userRepository.getObjectFactory();
        System.out.println(userFactory.getObject() == beanFactory);

    }


}
