package com.summer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("jdbc")
@Data
public class Jdbcproperties {
    private String driver;
    private String url;
    private String user;
    private String password;
}
