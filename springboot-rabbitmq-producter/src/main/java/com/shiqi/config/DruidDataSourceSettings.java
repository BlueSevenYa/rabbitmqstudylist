package com.shiqi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-09-01-16:43
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource")
@PropertySource("classpath:druid.properties")
public class DruidDataSourceSettings {
}
