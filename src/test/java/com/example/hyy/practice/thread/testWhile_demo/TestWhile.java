package com.example.hyy.practice.thread.testWhile_demo;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/8/13 18:17
 */
public class TestWhile {

    public static void main(String[] args) {

        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Thread thread1 = new Thread(producer);
        Consumer consumer = new Consumer(eventStorage);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}
