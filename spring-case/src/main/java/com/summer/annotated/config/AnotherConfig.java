package com.summer.annotated.config;

import com.summer.domain.Car;
import com.summer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * 注解配置
 * @author zhanghui
 */
@Configuration
@Import(AnnotatedConfiguration.class)
public class AnotherConfig {

    @Autowired
    private AnnotatedConfiguration annotatedConfiguration;

    /**
     * car bean
     */
//    @Bean
//    public User otherUser() {
//        User otherUser = new User();
//        otherUser.setCar(annotatedConfiguration.car());
//        return otherUser;
//    }
}
