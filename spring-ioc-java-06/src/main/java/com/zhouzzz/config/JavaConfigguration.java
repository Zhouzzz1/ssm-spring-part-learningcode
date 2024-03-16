package com.zhouzzz.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * java的配置类，替代xml的配置文件,能干下面三件事
 *      1.包扫描注解配置
 *      2.引用外部的配置文件
 *      3.声明第三方依赖的bean组件、
 *
 *
 *
 *    步骤一 添加@Configuration 代表我们是配置类
 *    步骤二 实现上面的三个功能注解
 */
@ComponentScan("com.zhouzzz.ioc_01")
@PropertySource("classpath:jdbc.properties")
@Configuration
public class JavaConfigguration {

    @Value("${zhouzzz.url}")
    private String url;

    @Value("${zhouzzz.driver}")
    private String driver;

    @Value("${zhouzzz.username}")
    private String username;

    @Value("${zhouzzz.password}")
    private String password;
    /**
     * 方法的返回值==bean组件的类型或者他的接口和父类
     * 方法的名字==bean id
     *
     * 方法体可以自定义实现过程即可
     *
     * 最重要的一步: 写上@Bean 会真正让配置类的方法创建的组件存储到ioc容器中
     *
     * 问题1： beanName的问题
     *          默认: 方法名
     *          指定： name/value属性起名字，覆盖方法名
     *问题2：周期方法如何指定
     *          原有注解方法: PostConstruct+PreDestroy注解指定
     *          bean属性绑定:initMethod+destroyMethod属性指定
     *问题3:作用域
     *          和以前一样@Scope注解，默认单例
     *问题4:如何引用其他的ioc组件
     *      直接调用对法的bean方法即可
     *      直接形参变量进行引入要求必须有对应的组件，
     *      如果有多个,可以使用形参名称dataSource等同于对应的beanid标识即可
     * @return
     */
    //引用外部的配置文件
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(name = "ergouzi",initMethod = "",destroyMethod = "")
    public DruidDataSource dataSource(){
        //实现具体的实例化过程
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;

    }

    //JdbcTemplate -> Datasource
//    @Bean
//    public JdbcTemplate jdbcTemplate(){
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        //需要DataSource 需要ioc容器的其他组件
//        //方案1 如果其他组件也是@Bean 方法 可以直接调用/从ioc容器获取组件
//        jdbcTemplate.setDataSource(dataSource());
//        return jdbcTemplate;
//    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //需要DataSource 需要ioc容器的其他组件
        //方案2 形参列表声明想要的组价类型，可以是一个也可以是多个 ioc容器也会注入
        //如果没有:形参类型注入,要求必须有对应的类型的组件，如果没有抛异常
        //如果有多个,可以使用形参名称dataSource等同于对应的beanid标识即可
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
