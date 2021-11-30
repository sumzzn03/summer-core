package com.sam.mybatis;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.sam.mybatis.dao.Department;
import com.sam.mybatis.dao.Employee;
import com.sam.mybatis.mapper.DepartmentMapper;
import com.sam.mybatis.mapper.EmployeeDynamicMapper;
import com.sam.mybatis.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

@Slf4j
public class MybatisDynamicTest {

    /**
     * 动态查询 if、where
     * @throws Exception
     */
    @Test
    public void dynamicQueryTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        EmployeeDynamicMapper mapper = session.getMapper(EmployeeDynamicMapper.class);
        Employee param = new Employee();
        param.setId(null);
        param.setLastName("tom");
        param.setEmail("");
        param.setGender("0");
        List<Employee> employeeList = mapper.getEmployeeListByIf(param);
        log.info(JSON.toJSONString(employeeList));
        session.close();
    }

    /**
     * 动态查询 trim
     * @throws Exception
     */
    @Test
    public void dynamicTrimQueryTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        EmployeeDynamicMapper mapper = session.getMapper(EmployeeDynamicMapper.class);
        Employee param = new Employee();
        param.setId(null);
        param.setLastName("tom");
        param.setEmail("");
        param.setGender("0");
        List<Employee> employeeList = mapper.getEmployeeListByIf(param);
        log.info(JSON.toJSONString(employeeList));
        session.close();
    }

    /**
     * 动态查询 choose
     * @throws Exception
     */
    @Test
    public void dynamicChooseQueryTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        EmployeeDynamicMapper mapper = session.getMapper(EmployeeDynamicMapper.class);
        Employee param = new Employee();
        param.setId(1);
        param.setLastName("tom");
        param.setEmail("");
        param.setGender("0");
        List<Employee> employeeList = mapper.getEmployeeListByChoose(param);
        log.info(JSON.toJSONString(employeeList));
        session.close();
    }

    /**
     * 动态查询 set
     * @throws Exception
     */
    @Test
    public void dynamicSetTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        EmployeeDynamicMapper mapper = session.getMapper(EmployeeDynamicMapper.class);
        Employee param = new Employee();
        param.setId(1);
        param.setLastName("ee");
        param.setEmail("eee@163.com");
        param.setGender("0");
        mapper.updateEmployee(param);
        session.close();
    }

    /**
     * 动态查询 foreach
     * @throws Exception
     */
    @Test
    public void dynamicForEachQueryTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        EmployeeDynamicMapper mapper = session.getMapper(EmployeeDynamicMapper.class);
        List<Employee> employeeList = mapper.getEmployeeListByForEach(Lists.newArrayList(1, 3));
        log.info(JSON.toJSONString(employeeList));
        session.close();
    }
}
