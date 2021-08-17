package com.sam.mybatis.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 部门 dao
 *
 * @since 2021-08-15
 * @author zhanghui
 */
@Getter
@Setter
public class Department {

    /**
     * id
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门员工
     */
    private List<Employee> employeeList;
}
