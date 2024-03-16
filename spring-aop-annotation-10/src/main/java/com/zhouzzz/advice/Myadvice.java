package com.zhouzzz.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * 定义四个增强方法 获取目标方法的信息 返回值 异常对象
 *
 * 1.定义方法 增强代码
 * 2.使用注解指定对应位置
 * 3，配置切点表达式选中方法
 * 4.切面和ioc的配置
 * 5.开启aspectj注解的支持
 *
 * TODO:增强方法中获取目标方法的信息
 *      1.全部增强方法中，获取目标方法的信息(方法名，参数，访问修饰符，所属类的信息..)，
 *          只需要在方法体中添加形参即可(JoinPoint joinPoint)
 *          joinPoint包含目标方法的信息，import org.aspectj.lang.JoinPoint;
 *      2.返回的结果 -  @AfterReturning
 *          (Object result) result接收返回结果的
 *          @AfterReturning(value = "execution(* com..impl.*.*(..))",returning = "形参名")
 *      3.异常的信息 -  @AfterThrowing
 *          (Throwable throwable) throwable接收异常信息的
 *          @AfterThrowing(value = "execution(* com..impl.*.*(..))",throwing = "形参名")
 *
 */
@Component
@Aspect
public class Myadvice {
    @Before("com.zhouzzz.pointcut.MyPointCut.mypc()")
    public void before(JoinPoint joinPoint)
    {
        //1.获取方法属于类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        //2.获取方法名称
        int modifiers = joinPoint.getSignature().getModifiers();//int转成字符串类型，通过反射Modifier.toString
        String string = Modifier.toString(modifiers);
        String name = joinPoint.getSignature().getName();//获取方法名
        //3,获取参数列表
        Object[] args = joinPoint.getArgs();//获取目标方法参数

    }

    @AfterReturning(value = "com.zhouzzz.pointcut.MyPointCut.mypc()",returning = "result")//result接返回结果的
    public void afterReturning(JoinPoint joinPoint,Object result)
    {

    }

    @After("com.zhouzzz.pointcut.MyPointCut.mypc()")
    public void after(JoinPoint joinPoint)
    {

    }
    @AfterThrowing(value = "com.zhouzzz.pointcut.MyPointCut.mypc()",throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint ,Throwable throwable)
    {

    }
}
