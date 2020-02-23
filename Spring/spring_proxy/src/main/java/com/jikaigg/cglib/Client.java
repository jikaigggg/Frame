package com.jikaigg.cglib;

import com.jikaigg.proxy.Producer;
import com.jikaigg.proxy.impl.ProducerImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理：
 *      特点：字节码随用随创建，随用随加载
 *      作用：不修改源码的基础上对方法增强
 * 分类：
 *      基于接口的动态代理
 *      基于子类的动态代理
 * 基于子类的动态代理：
 *      涉及的类：Enhancer
 *      提供者：第三方cglib库
 * 如何创建代理对象：
 *      使用Enhancer类中的create方法
 * 创建代理对象的要求：
 *      被代理类不能试最终类
 * create方法的参数：
 *      Class:字节码
 *            他是用于指定被代理对象的字节码
 *      InvocationHandler：用于提供增强的代码
 *                         他是让我们写如何代理。我们一般都是写一个改接口的实现类，通常情况下都是匿名内部类，但不是必须写
 */
public class Client {
    public static void main(String[] args) {
        final ProducerImpl producer = new ProducerImpl();
        Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             * @param o
             * @param method
             * @param objects
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return null;
            }
        });
    }
}
