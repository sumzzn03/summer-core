package com.summer.annotated.config;

import com.summer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 注解配置
 * @author zhanghui
 */
@Configuration
@ImportResource("/META-INF/annoteted-import-application-context.xml")
public class ImportConfig {

}
