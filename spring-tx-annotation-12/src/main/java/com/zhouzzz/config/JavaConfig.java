package com.zhouzzz.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.zhouzzz")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement//开启事务注解的支持
public class JavaConfig {
    @Value("${zhouzzz.driver}")
    private String driver;
    @Value("${zhouzzz.url}")
    private String url;
    @Value("${zhouzzz.username}")
    private String username;
    @Value("${zhouzzz.password}")
    private String password;

    //druid连接池
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return  dataSource;
    }

    //jdbcTemplate
    //形参名也是有作用的，如果当你对应的类型在ioc容器中右多个组件，他会默认跟形参变量名作bean id查找，如果只有一个就根据类型查找
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return  jdbcTemplate;
    }

    /**
     * 装配事务管理实现对象
     * @param dataSource
     * @return
     */
    @Bean
    public TransactionManager transactionManager(DataSource dataSource){

        //内部要进行事务的操作，基于的连接池，需要连接池对象
        return new DataSourceTransactionManager(dataSource);
    }
}
