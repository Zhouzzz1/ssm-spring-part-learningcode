package com.zhouzzz.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 增强类的内部要存储的增强代码
 */
@Component
@Aspect
public class LogAdvice {


    @Before("com.zhouzzz.pointcut.MyPointCut.pc()")
    public void start(){

        System.out.println("方法开始了...");
    }
    @After("com.zhouzzz.pointcut.MyPointCut.pc()")
    public void after()
    {
        System.out.println("方法结束了...");
    }
    @AfterThrowing("com.zhouzzz.pointcut.MyPointCut.pc()")
    public void error()
    {
        System.out.println("方法出错了...");
    }
}
