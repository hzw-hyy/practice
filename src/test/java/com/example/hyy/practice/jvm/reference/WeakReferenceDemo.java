package com.example.hyy.practice.jvm.reference;

import java.lang.ref.SoftReference;

/**
 * Copyright (C), 2018-2021
 * FileName: WeakReferenceDemo
 * Author:   yggc
 * Date:     2021-12-14 17:14
 * Description: 弱引用
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);

        System.out.println("o1 = " + o1);
        System.out.println("o2 = " + softReference.get());
        o1 = null;

        try {
            byte[] bytes = new byte[300 * 1024 * 1024];
        } finally {
            System.out.println("o1 = " + o1);
            System.out.println("o2 = " + softReference.get());
        }

    }
}
