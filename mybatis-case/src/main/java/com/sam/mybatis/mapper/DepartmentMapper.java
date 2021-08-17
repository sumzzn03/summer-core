package com.sam.mybatis.mapper;

import com.sam.mybatis.dao.Department;

/**
 * 部门映射 Mapper
 *
 * @since 2021-08-16
 * @author zhanghui
 */
public interface DepartmentMapper {

    /**
     * 通过 id 查询部门
     *
     * @param id id
     * @return 部门信息
     */
    Department getDeptById(Integer id);

    /**
     * 通过 id 查询部门，级联查询员工信息
     *
     * @param id id
     * @return 所有信息
     */
    Department getDeptAndEmpListByAssoc(Integer id);

    /**
     * 通过 id 查询部门，分步查询员工信息
     *
     * @param id id
     * @return 所有信息
     */
    Department getDeptAndEmpListByStep(Integer id);
}
