package am.zzz.beans.initialization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationDemo {

    @Bean
    public Car getCar() {
        return new Car();
    }
}
