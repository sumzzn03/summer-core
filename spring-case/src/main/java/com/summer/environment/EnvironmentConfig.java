package com.summer.environment;

import com.summer.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 用于环境测试的配置信息
 */
@Configuration
public class EnvironmentConfig {

    @Profile("default")
    @Bean("person")
    public Person defaultPerson() {
        return new Person("a");
    }

    @Profile("dev")
    @Bean("person")
    public Person devPerson() {
        return new Person("b");
    }

    @Profile("prod")
    @Bean("person")
    public Person prodPerson() {
        return new Person("c");
    }
}
