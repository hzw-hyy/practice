package com.example.hyy.practice.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/8/8 17:27
 */
public class CountDownLatchDemo1 {
    public static void main(String[] args) throws InterruptedException {
        closedoor();
    }

    static void closedoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1L);
                    System.out.println(Thread.currentThread().getName() + "\t learning");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        countDownLatch.await();
        TimeUnit.SECONDS.sleep(1L);
        System.out.println(Thread.currentThread().getName() + "\t leaving");
    }
}
