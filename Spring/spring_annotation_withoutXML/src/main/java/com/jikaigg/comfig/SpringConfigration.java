package com.jikaigg.comfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 该类是一个配置类，它的作用和bean.xml是一样的
 * spring新注解
 *
 * @Configuration 作用：指定当前类是一个配置类
 * 细节：当配置类作为AnnotationConfigApplicationContext创建的参数时，该注解可以不写
 * @ComponentScan 作用：用于通过注解指定spring在创建容器时扫描的包
 * 属性：value：和basePackages的作用是一样的，都是用于指定创建容器是要扫描的包，使用此注解就等同于在XML中配置了<context:component-scan base-package="com.jikaigg"></context:component-scan>
 * @Bean 作用：用于把当前当前方法的返回值作为bean对象存入spring的ioc容器中
 * 属性：name：用于指定bean的id。不写时，默认值是当前方法的名称
 * 细节：当我们使用注解配置方法是，如果方法有参数，spring框架回去容器中查找有没有可用额Bean对象，查找的方式和AutoWried是一样的。
 * @Import 作用：用于导入其他的配置类
 * 属性：value：用于指定其他配置类的字节码，使用import注解之后有import注解的类就是主(父)配置类，导入的都是副(子)配置类
 */
@Configuration
@ComponentScan("com.jikaigg")
public class SpringConfigration {
    /**
     * 用于创建一个QueryRunner对象
     *
     * @param ds
     * @return
     */
    @Bean("runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource ds) {
        return new QueryRunner(ds);
    }

    /**
     * 创建数据源对象
     *
     * @return
     */
    @Bean("dataSource")
    public DataSource createDataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/jikaigg");
            ds.setUser("root");
            ds.setPassword("123456");
            return ds;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

    }
}
