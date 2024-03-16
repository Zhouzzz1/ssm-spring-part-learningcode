package com.zhouzzz.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxAroundAdvice {
    /**
     * 环绕通知是需要你在方通知中，定义目标方法的执行
     * @param joinPoint 目标方法(获取目标方法信息 多了一个执行方法)
     * @return  目标方法的返回值
     */
    public Object transaction(ProceedingJoinPoint joinPoint)  {

        //目标方法被执行即可
        Object[] args = joinPoint.getArgs();
        try {
            //增强代码 -> before
            System.out.println("开启事务");
            Object result = joinPoint.proceed(args);
            System.out.println("结束事务");
        } catch (Throwable e) {
            System.out.println("事务回滚");
            throw new RuntimeException(e);
        }
        return null;

    }
}
