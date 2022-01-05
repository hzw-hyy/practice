package com.example.hyy.practice.jvm.reference;

/**
 * @author 18845
 * @date 2021年12月14日17点12分
 *
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = o1;
        o1 = null;
        System.gc();
        System.out.println(o2);
    }
}
