package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
@ComponentScan({"com.summer"})
public class SpringConfiguration {

}
