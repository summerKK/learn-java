package com.summer.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(Jdbcproperties.class)
public class JdbcConfig {

    @Bean("datasource")
    public DataSource dataSource(Jdbcproperties prop) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(prop.getDriver());
        dataSource.setUrl(prop.getUrl());
        dataSource.setUsername(prop.getUser());
        dataSource.setPassword(prop.getPassword());
        return dataSource;
    }
}
