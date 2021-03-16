package com.summer.domain;

import com.summer.annotated.UserAnno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@UserAnno
@Slf4j
public class User implements InitializingBean, DisposableBean {
    private Long id;
    private String name;
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserAnno{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void beanInit() {
        log.info("bean init");
    }

    public void beanDestroy() {
        log.info("bean destroy");
    }

    @Override
    public void destroy() {
        log.info("interface destroy");
    }

    @Override
    public void afterPropertiesSet() {
        log.info("interface init");
    }

    @PostConstruct
    public void annotatedInit() {
        log.info("annotated init");
    }

    @PreDestroy
    public void annotatedDestroy() {
        log.info("annotated destroy");
    }
}
