package com.example.hyy.practice.aop.jdk;

import org.junit.jupiter.api.Test;

public class AopTest {

    public static void main(String[] args) {
        Userservice userservice = new UserserviceImpl();
        Userservice userserviceProxy = (Userservice) ProxyFactory
                .createProxy(userservice);
        userserviceProxy.add();
    }

    @Test
    public void testAop() {
        Userservice userservice = new UserserviceImpl();
        Userservice userserviceProxy = (Userservice) ProxyFactory
                .createProxy(userservice);
        userserviceProxy.add();
    }
}
