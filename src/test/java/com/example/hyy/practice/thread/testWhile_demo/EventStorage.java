package com.example.hyy.practice.thread.testWhile_demo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 在多线程操作中，我们常常会遇到需要先判断信号量状态是否就绪，然后执行后续操作的场景。
 * 这里对状态的判断使用的是while而不是单线程下常用的if。
 * 以下示例展示了一个简单的生产者-消费者模型：当队列满的时候，阻塞set；
 * 当队列为空的时候，阻塞get操作。
 * 原因：
 * 在线程中notify或者notifyAll会唤醒一个或多个线程，
 * 当线程被唤醒后，被唤醒的线程继续执行阻塞后的操作。
 * 这里分析一下get操纵：当某个线程得到锁时storage为空，
 * 此时它应该wait，下次被唤醒时（任意线程调用notify），storage可能还是空的。
 * 因为有可能其他线程清空了storage。
 * 如果此时用的是if它将不再判断storage是否为空，直接继续，这样就引起了错误。
 * 但如果用while则每次被唤醒时都会先检查storage是否为空再继续，这样才是正确的操作；
 * 生产也是同一个道理。
 *
 * @author hyy
 * @version 1.0
 * @date 2020/8/13 17:59
 */
public class EventStorage {
    private int maxSize;
    private List<Date> storage;

    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<>();
    }

    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());

        System.out.printf("Set: %d", storage.size());
        System.out.printf("\n");
        notifyAll();
    }

    public synchronized void get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Get: %d: %s", storage.
                size(), ((LinkedList<?>) storage).poll());
        System.out.printf("\n");
        notifyAll();
    }
}