package com.zhouzzz;

//用spring的测试环境，只需要指定配置类和配置环境
//如果用的配置文件就用 @SpringJUnitConfig(lacations=JavaConfig.class)
//配置类就用@SpringJUnitConfig(value = JavaConfig.class)

import com.alibaba.druid.pool.DruidDataSource;
import com.zhouzzz.config.JavaConfig;
import com.zhouzzz.service.Calculator;
import com.zhouzzz.service.impl.CalculatorPureImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(JavaConfig.class)
public class SpringAopTest {
   // private CalculatorPureImpl calculatorPure;
    //CalculatorPureImpl放到了ioc容器，接口也可以取。有了aop,
    //所以，如果有接口，再取值的时候，直接用接口去取

    @Autowired
    private Calculator calculator;

    @Test
    public void test1(){
        int add = calculator.add(1,1);
        System.out.println("add = " + add);


    }

}
