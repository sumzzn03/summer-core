package com.summer.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * commons-logging 测试类
 */
public class CommonsLoggingTest {

    public static void main(String[] args) {
        /**
         * 默认会查找是否有 Log4j，否则使用 JDK 的 Logger
         * commons-logging.properties 配置文件，可以配置 commons-logging
         * Log4j 可以强制配置，即使不配置也可以自动扫描到
         *
         * commons-logging 只是一个包装器，用来统一方式的方式：具体实现可以由 JDK 或 log4j 来实现
         */
        Log log = LogFactory.getLog(CommonsLoggingTest.class);
        log.info("start...");
        log.warn("end.");
    }
}
