package com.sam.mybatis;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    /**
     * id
     */
    private Integer id;

    /**
     * 名字
     */
    private String lastName;

    /**
     * email
     */
    private String email;

    /**
     * 性别
     */
    private String gender;
}
