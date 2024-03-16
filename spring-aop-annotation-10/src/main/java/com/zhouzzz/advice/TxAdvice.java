package com.zhouzzz.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 使用普通方式进行事务的添加
 */
@Component
@Aspect
public class TxAdvice {
    @Before("com.zhouzzz.pointcut.MyPointCut.pc()")
    public void begin(){
        System.out.println("事务开始");
    }
    @AfterReturning("com.zhouzzz.pointcut.MyPointCut.pc()")
    public void commit(){
        System.out.println("事务提交");
    }
    @AfterThrowing("com.zhouzzz.pointcut.MyPointCut.pc()")
    public  void rollback(){
        System.out.println("事务回滚");
    }
}
