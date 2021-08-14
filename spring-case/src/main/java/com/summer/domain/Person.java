package com.summer.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Person {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
