package com.example.hyy.practice.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    // ��ǿ�Ĵ�����
    final static Myspect ms = new Myspect();

    public static Object createProxy(final Object us) {

        Object newProxyInstance = Proxy.newProxyInstance(us.getClass()
                        .getClassLoader(), us.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method,
                                         Object[] args) throws Throwable {
                        ms.pre();// ��ǿ�Ĵ���
                        Object invoke = method.invoke(us, args);
                        ms.next();// ��ǿ�Ĵ���
                        return invoke;
                    }
                });
        return newProxyInstance;
    }
}
