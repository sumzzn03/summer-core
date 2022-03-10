package com.summer.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Log4j 测试类
 */
public class Log4jTest {

    public static void main(String[] args) {
        // 直接通过 commons-logging 来访问即可

        // 日志隔离级别 trace debug info warn error fatal
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");

        // 配置文件，如果配置文件不存在，
    }
}
