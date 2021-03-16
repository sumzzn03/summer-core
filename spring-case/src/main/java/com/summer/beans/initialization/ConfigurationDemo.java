package com.summer.beans.initialization;

import org.springframework.context.annotation.Bean;

public class ConfigurationDemo {

    @Bean
    public Car getCar() {
        return new Car();
    }
}
