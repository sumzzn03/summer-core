package com.summer.annotated.config;

import com.summer.domain.Car;
import com.summer.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;

/**
 * 注解配置
 * @author zhanghui
 */
@Configuration
public class AnnotatedConfiguration {

    /**
     * @bean 注解只能用与方法上
     * @bean 所在的类，需要使用@configuration 或 @component标记
     * bean 的名称等同于方法名
     */
    @Bean(name = "user", initMethod = "beanInit", destroyMethod = "beanDestroy")
    @Scope("singleton")
    @Description("this is description")
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("sam");
        user.setCar(car());
        // 属性注入与构造器注入
        return user;
    }

    /**
     * car bean
     */
    @Bean
    public Car car() {
        return new Car();
    }
}
