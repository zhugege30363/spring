package com.imooc.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;
@Configuration
@MapperScan("com.imooc.demo.dao") //配置mybatis mapper的扫描路径
public class DataSourceConfiguration {

    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")   /*在IOC容器里注册一个DataSource*/
     public ComboPooledDataSource createDataSource() throws PropertyVetoException {

        ComboPooledDataSource dataSource=new ComboPooledDataSource();


        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);

        //关闭连接后不自动commit
        dataSource.setAutoCommitOnClose(false);
        return  dataSource;
    }
}
