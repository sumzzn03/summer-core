package com.sam.mybatis;

import com.alibaba.fastjson.JSON;
import com.sam.mybatis.dao.Department;
import com.sam.mybatis.dao.Employee;
import com.sam.mybatis.mapper.DepartmentMapper;
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
public class MybatisTest {

    /**
     * 配置：
     * 1. 根据 mybatis 全局配置文件，配置环境信息
     * 2. 定义数据表与实体类的映射文件，配置可执行的 sql 语句，将映射文件注册到全局配置文件
     *
     * 编码：
     * 1. 根据全局配置文件，创建一个 SqlSessionFactory
     * 2. 使用 SqlSessionFactory 工厂，获取到 SqlSession 对象，该对象打开了一个会话
     * 3. 选择要执行的映射文件中的 sql，设置配置的参数
     *
     * @throws Exception
     */
    @Test
    public void linkMysqlOld() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        Employee employee = session.selectOne("org.sam.mybatis.EmployeeMapperNS.selectEmp", 1);
        session.close();

        log.info(JSON.toJSONString(employee));
    }

    /**
     * 通过接口映射配置文件
     * @throws Exception
     */
    @Test
    public void linkMysqlInterface() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmpById(1);
        session.close();

        log.info(JSON.toJSONString(employee));
    }

    /**
     * 增删改查
     *
     * @throws Exception
     */
    @Test
    public void curdTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 会话需提交
        SqlSession session = sqlSessionFactory.openSession();
        // 会话不用提交
//        SqlSession session = sqlSessionFactory.openSession(true);

        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setLastName("tom");
        employee.setGender("1");
        employee.setEmail("aaa@163.com");
        mapper.addEmp(employee);
        log.info(employee.getId().toString());

//        Employee employee = new Employee();
//        employee.setId(2);
//        employee.setLastName("bbb");
//        employee.setGender("0");
//        employee.setEmail("ccc@163.com");
//        mapper.updateEmp(employee);

//        mapper.deleteEmpById(2);

        session.commit();
        session.close();
    }

    /**
     * 测试集合
     * @throws Exception
     */
    @Test
    public void listTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = mapper.getEmpsByLikeLastName("tom");
        session.close();

        log.info(JSON.toJSONString(employeeList));
    }

    /**
     * 测试resultMap
     * @throws Exception
     */
    @Test
    public void resultMapTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmpByIdResultMap(1);
        session.close();

        log.info(JSON.toJSONString(employee));
    }

    /**
     * 级联查询测试
     * @throws Exception
     */
    @Test
    public void associationSimpleQueryTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmpAndDeptBySQL(1);
        session.close();

        log.info(JSON.toJSONString(employee));
    }

    /**
     * 分步级联查询
     * @throws Exception
     */
    @Test
    public void associationQueryByStepTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmpAndDeptByStep(1);
        session.close();

        log.info(JSON.toJSONString(employee));
    }

    /**
     * 延迟加载查询
     * @throws Exception
     */
    @Test
    public void lazyQueryTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmpAndDeptByStep(1);
        log.info(employee.getLastName());
//        log.info(employee.getDept().getDeptName());
        session.close();
    }

    /**
     * 集合类型的级联查询
     * @throws Exception
     */
    @Test
    public void collectionAssocQueryTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
        Department department = mapper.getDeptAndEmpListByAssoc(1);
        log.info(JSON.toJSONString(department));
        session.close();
    }

    /**
     * 集合类型的分步查询
     * @throws Exception
     */
    @Test
    public void collectionStepQueryTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
        Department department = mapper.getDeptAndEmpListByStep(3);
        log.info(JSON.toJSONString(department));
        session.close();
    }

    /**
     * 使用鉴别器
     * @throws Exception
     */
    @Test
    public void discriminatorQueryTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmpAndDeptByStepAndDis(3);
        log.info(JSON.toJSONString(employee));
        session.close();
    }
}
