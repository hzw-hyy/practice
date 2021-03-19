package com.example.hyy.practice.countdownlatch;

import com.example.hyy.practice.enum_demo.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/8/10 10:24
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {

        sixCountry();
    }

    static void sixCountry() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t die");
                countDownLatch.countDown();
            }, CountryEnum.forEach(i).getName()).start();
        }
        countDownLatch.await();
        System.out.println("Qin unified the six states.");
    }
}
