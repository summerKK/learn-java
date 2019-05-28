package com.summer.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

    public void beforeWrite() {
        System.out.println("前置通知");
    }

    public void afterReturningWrite() {
        System.out.println("后置通知");
    }

    public void afterThrowingWrite() {
        System.out.println("异常通知");
    }

    public void afterWrite() {
        System.out.println("最终通知");
    }

    // 环绕通知
    public Object aroundWrite(ProceedingJoinPoint proceedingJoinPoint) {
        Object proceed = null;
        try {
            System.out.println("前置通知");
            Object[] args = proceedingJoinPoint.getArgs();
            System.out.println("后置通知");
            proceed = proceedingJoinPoint.proceed(args);
        } catch (Throwable e) {
            System.out.println("异常通知");
            throw new RuntimeException(e);
        } finally {
            System.out.println("最终通知");
        }
        return proceed;
    }
}
