package com.example.hyy.practice.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    // 增强的代码类
    final static Myspect ms = new Myspect();

    public static Object createProxy(final Object us) {

        Object newProxyInstance = Proxy.newProxyInstance(us.getClass()
                        .getClassLoader(), us.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method,
                                         Object[] args) throws Throwable {
                        ms.pre();// 增强的代码
                        Object invoke = method.invoke(us, args);
                        ms.next();// 增强的代码
                        return invoke;
                    }
                });
        return newProxyInstance;
    }
}
