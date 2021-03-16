package com.summer.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Phone {
    private String name;
    private int memory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
