package com.summer.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Car {
    private String brand;
    private int price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void carInit() {
        log.info("car init");
    }
}
