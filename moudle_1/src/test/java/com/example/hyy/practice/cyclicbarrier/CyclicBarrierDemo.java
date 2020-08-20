package com.example.hyy.practice.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/8/10 11:32
 */
public class CyclicBarrierDemo {


    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier0 = new CyclicBarrier(2);
        System.out.println("init parties: " + cyclicBarrier0.getParties());
        System.out.println("init numwait: " + cyclicBarrier0.getNumberWaiting());
        cyclicTest(cyclicBarrier0, 1);
        cyclicTest(cyclicBarrier0, 2);
        cyclicTest(cyclicBarrier0, 3);
    }


    static void cyclicTest(CyclicBarrier cyclicBarrier0, int i) throws InterruptedException {
        new Thread(() -> {
            System.out.println("the " + i + " thread: " + Thread.currentThread().getName());
            try {
                cyclicBarrier0.await();
                System.out.println(Thread.currentThread().getName() + " is running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is terminated...");
        }).start();
        Thread.sleep(10);
        System.out.println("the " + i + " thread numwait: " + cyclicBarrier0.getNumberWaiting());
        Thread.sleep(10);
    }
}
