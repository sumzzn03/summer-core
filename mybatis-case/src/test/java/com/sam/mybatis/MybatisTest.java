package com.sam.mybatis;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

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
}
