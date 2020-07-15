package com.example.hyy.practice.blockingqueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/6/23 17:20
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {

        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " put 1");
                synchronousQueue.put(1);
                System.out.println(Thread.currentThread().getName() + " put 2");
                synchronousQueue.put(2);
                System.out.println(Thread.currentThread().getName() + " put 3");
                synchronousQueue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(synchronousQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(synchronousQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();


    }
}
