package com.example.hyy.practice.blockingqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程通信之生产者消费者传统模式
 * 这种模式的问题/弊端：
 * 1.当为多个线程的情况下怎么办？
 * 目前只有两个线程，所以使用signalAll（）方法唤醒的肯定是另一个线程，但是当为多个线程时无法做到精确唤醒。
 * 2.使用的是锁机制，减少了并发性，降低了执行效率。
 *
 * 题目：一个初始值为0的变量，两个线程对其交替操作，一个加1，一个减1，来5轮。
 * 1 线程 操作（方法） 资源类
 * 2 判断 干活        通知
 * 3 防止虚假唤醒机制
 *
 * @author hyy
 * @version 1.0
 * @date 2020/6/24 17:27
 */

public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AAA").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BBB").start();
    }
}

class ShareData {// 资源类
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // 相当于生产者
    public void increment() throws Exception {

        lock.lock();
        try {
            // 1.判断
            // 什么是防止虚假唤醒
            // 传统生产者消费者模式中在判断时防止虚假唤醒使用while而不用if是为什么？
            while (number != 0)
                condition.await();
            // 2.干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3.通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 相当于消费者
    public void decrement() throws Exception {

        lock.lock();
        try {
            // 1.判断
            while (number == 0)
                condition.await();
            // 2.干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3.通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

