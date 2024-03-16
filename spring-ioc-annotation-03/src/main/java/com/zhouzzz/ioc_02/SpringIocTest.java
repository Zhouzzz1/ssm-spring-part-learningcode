package com.zhouzzz.ioc_02;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-02.xml");
        UserController userController
                = (UserController) applicationContext.getBean(UserController.class);
        userController.show();
    }
}
