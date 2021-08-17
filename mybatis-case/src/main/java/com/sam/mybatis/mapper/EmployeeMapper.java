package com.sam.mybatis.mapper;

import com.sam.mybatis.dao.Employee;

import java.util.List;

/**
 * 增、删、改可以自动映射以下类型返回值：
 * Integer、Long、Boolean、void
 *
 * 参数值的映射
 * 1. 单个参数: 名字随意
 * 2. 多个参数：
 *   内置参数：param1 param2 ...，或者 0 1 ...
 *   命名参数：使用 @Param 注解指定参数名称
 * 3. 支持 Map 传参
 */
public interface EmployeeMapper {

    /**
     * 根据 id 查询员工
     * @param id id
     * @return 员工
     */
    Employee getEmpById(Integer id);

    /**
     * 添加员工
     * @param employee 员工
     */
    void addEmp(Employee employee);

    /**
     * 更新员工信息
     * @param employee 员工
     */
    void updateEmp(Employee employee);

    /**
     * 根据 id 删除员工
     * @param id id
     */
    void deleteEmpById(Integer id);


//    Employee getEmpById(@Param("id")Integer id);

//    Employee getEmpById(Map<String, Object> map);

    /**
     *
     * @param lastName
     * @return
     */
    List<Employee> getEmpsByLikeLastName(String lastName);

    /**
     * 根据 id 查询员工，使用 ResultMap 封装结果
     * @param id id
     * @return 员工
     */
    Employee getEmpByIdResultMap(Integer id);

    /**
     * 通过连表 sql，进行级联查询
     * @param id id
     * @return 员工
     */
    Employee getEmpAndDeptBySQL(Integer id);

    /**
     * 通过分步 sql，进行级联查询
     * @param id id
     * @return 员工
     */
    Employee getEmpAndDeptByStep(Integer id);

    /**
     * 通过部门 id，查询所有员工
     * @param deptId 部门 id
     * @return 员工
     */
    List<Employee> getEmployeeListByDeptId(Integer deptId);

    /**
     * 使用鉴别器
     * @param id id
     * @return 员工
     */
    Employee getEmpAndDeptByStepAndDis(Integer id);
}
