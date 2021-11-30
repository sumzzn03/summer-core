package com.sam.mybatis.mapper;

import com.sam.mybatis.dao.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDynamicMapper {

    /**
     * 根据参数查询员工列表 if、where
     * @param employee 参数
     * @return 员工列表
     */
    List<Employee> getEmployeeListByIf(Employee employee);

    /**
     * 根据参数查询员工列表 trim
     * @param employee 参数
     * @return 员工列表
     */
    List<Employee> getEmployeeListByTrim(Employee employee);

    /**
     * 根据参数查询员工列表 choose
     * @param employee 参数
     * @return 员工列表
     */
    List<Employee> getEmployeeListByChoose(Employee employee);

    /**
     * 更新员工信息 set
     * @param employee 员工信息
     */
    void updateEmployee(Employee employee);

    /**
     * 根据参数查询员工列表 foreach
     * @param idList id 列表
     * @return 员工列表
     */
    List<Employee> getEmployeeListByForEach(@Param("idList")List<Integer> idList);
}
