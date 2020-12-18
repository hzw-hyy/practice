package com.example.hyy.practice.gc;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/9/14 16:38
 */
public class HelloGC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello gc");

        Thread.sleep(Integer.MAX_VALUE);
    }
}
