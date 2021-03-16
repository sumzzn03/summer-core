package com.summer.logging;

import com.alibaba.fastjson.JSON;

import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * JDK Logging 测试类
 */
public class JdkLoggingTest {
    public static void main(String[] args) throws Exception {
        /**
         * 创建一个 LogManager
         *
         * LogManager 的初始化方式：通过静态块来完成：先判断 java.util.logging.manager 系统属性，有没有设置，没有设置的话直接 new LogManager()
         * LogManager 是一个单例对象（饿汉式方式创建），后续任何 Logger 使用的都是同一个 LogManager
         */
        LogManager logManager = LogManager.getLogManager();

        /**
         * 读取 Logger 的配置，载入到 LogManager 中
         * readConfiguration 读取的方式也是通过 Properties 进行解析的
         * 类路径是通过类加载器的 Class.getResourceAsStream 定位资源的
         */
        InputStream in = JdkLoggingTest.class.getResourceAsStream("/logging/jdk_logger.properties");
        logManager.readConfiguration(in);

        // 创建一个 Logger 对象，进行输出
        Logger logger = Logger.getLogger("mylogger");
        logger.severe("这是[severe]信息");

        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");
        logger.info(JSON.toJSONString(logger.getHandlers()));
    }
}
