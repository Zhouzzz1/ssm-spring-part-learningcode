package com.zhouzzz.test;

import com.zhouzzz.config.JavaConfigguration;
import com.zhouzzz.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test
    public void test1(){
        //1.创建ioc容器

       /* 这行代码创建了一个基于Java配置类的Spring IoC容器。AnnotationConfigApplicationContext
         是一个实现了 ApplicationContext 接口的类，它通过Java配置类加载并初始化Spring容器。
         JavaConfigguration.class 作为参数传递给了 AnnotationConfigApplicationContext 构造方法，
         告诉Spring容器从哪个配置类中加载Bean的配置信息。*/
        ApplicationContext  applicationContext =
                new AnnotationConfigApplicationContext(JavaConfigguration.class);

        /*这行代码创建了另一个基于Java配置类的Spring IoC容器。同样是使用了 AnnotationConfigApplicationContext 类，
        并没有指定任何配置类作为参数。*/
        AnnotationConfigApplicationContext
                applicationContext1 = new AnnotationConfigApplicationContext();


        /*这行代码注册了一个Java配置类 JavaConfigguration 到刚刚创建的 applicationContext1 容器中。
        这样容器就知道从哪里加载Bean的配置信息。*/
        applicationContext1.register(JavaConfigguration.class);

        /*这行代码表示刷新容器，告诉Spring容器去扫描配置并初始化Bean。*/
        applicationContext1.refresh();

        //2.获取bean
        /*这行代码从 applicationContext 中获取了一个 StudentController 类型的Bean实例。
        在Spring IoC容器中，Bean是通过配置信息创建和管理的对象。*/
        StudentController bean = applicationContext.getBean(StudentController.class);
        System.out.println(bean);

    }
}
