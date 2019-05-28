package com.summer.utils;

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
}
