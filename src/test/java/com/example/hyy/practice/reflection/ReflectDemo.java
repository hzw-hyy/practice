package com.example.hyy.practice.reflection;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/7/2 11:00
 */
public class ReflectDemo {

    /**
     * 获取class对象的三种方式
     */
    @Test
    public void getBT() throws ClassNotFoundException {

        // 1
        Class<Date> aClass1 = Date.class;
        // 2
        Date date = new Date();
        Class<? extends Date> aClass2 = date.getClass();
        // 3
        Class<?> aClass3 = Class.forName("java.util.Date");

        System.out.println(aClass1);
        System.out.println(aClass2);
        System.out.println(aClass3);
    }
}
