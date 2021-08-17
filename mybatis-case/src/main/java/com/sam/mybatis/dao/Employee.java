package com.sam.mybatis.dao;

import lombok.Getter;
import lombok.Setter;

/**
 * 员工 dao
 *
 * @since 2021-08-16
 * @author zhanghui
 */
@Getter
@Setter
//@Alias("employee")
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

    /**
     * 部门
     */
    private Department dept;
}
