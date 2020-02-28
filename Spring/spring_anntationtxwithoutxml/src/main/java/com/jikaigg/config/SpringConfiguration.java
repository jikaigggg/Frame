package com.jikaigg.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring配置类，相当于bean.xml
 */
@Configuration
@ComponentScan("com.jikaigg")
@Import({JdbcConfig.class,TransectionConfig.class})
@PropertySource("jdbcConfig.properties")
@EnableTransactionManagement
public class SpringConfiguration {
}
