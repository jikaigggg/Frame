package com.jikaigg.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class advice {
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();  //得到方法执行所需的参数
            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志了--前置");
            rtValue = pjp.proceed(args);  //明确调用业务层方法（切入点方法）
            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志了--后置");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志了--异常");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志了--最终");

        }

    }
}
