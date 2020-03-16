package com.jikaigg.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Log implements MethodBeforeAdvice {
    //method要执行的目标方法，objects参数，o目标对象
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getCanonicalName() +" 的 "+method.getName()+" 被执行了");
    }
}
