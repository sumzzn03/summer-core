package com.summer.beans.initialization;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car implements InitializingBean, DisposableBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct 初始化中");
    }

    public void initCar() {
        System.out.println("自定义方法初始化");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 初始化");
    }


    @PreDestroy
    public void preDestroy(){
        System.out.println("PreDestroy 销毁中");
    }

    public void destroyCar() {
        System.out.println("自定义方法销毁中");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean 销毁中");
    }
}
