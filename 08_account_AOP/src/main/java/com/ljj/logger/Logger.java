package com.ljj.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

/**
 * 环绕通知好用，其它四种会有执行顺序问题，需注意：执行顺序为：前置-切点方法-最终-后置或异常
 */
@Component
@Aspect//表示当前类是一个切面类
public class Logger {

    /**
     * 前置通知
     */
    @Pointcut("execution(* com.ljj.service.impl.*.*(..))")
    private void pt1(){
        System.out.println("不知道这方法有屁用");
    }
    @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("前置通知开始记录日志！！！");
    }
    /**
     * 后置通知
     */
    @AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知开始记录日志！！！");
    }
    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    public void throwingPrintLog(){
        System.out.println("异常通知开始记录日志！！！");
    }
    /**
     * 最终通知
     */
    @After("pt1()")
    public void finalPrintLog(){
        System.out.println("最终通知开始记录日志！！！");
    }

    /**
     * 环绕通知
     */
    @Around("pt1()")
    public  void AroundPrintLog(ProceedingJoinPoint pjp){
        try {
            System.out.println("环绕前置通知开始记录日志！！！");
            pjp.proceed();//明确调用业务层方法（切入点方法）
            System.out.println("环绕后置通知开始记录日志！！！");
        }catch (Throwable e){
            System.out.println("环绕异常通知开始记录日志！！！");

        }finally {
            System.out.println("环绕最终通知开始记录日志！！！");
        }

    }
}
