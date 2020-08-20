package com.example.hyy.practice.thread;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * 死锁是指两个或者两个以上的进程在执行过程中
 * 因争夺资源而造成一种互相等待现象，
 * 若无外力干涉他们都无法推进下去。
 *
 * @author hyy
 * @version 1.0
 * @date 2020/7/6 15:32
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldThread(lockA, lockB), "threadAAA").start();
        new Thread(new HoldThread(lockB, lockA), "threadBBB").start();
    }
}

class HoldThread implements Runnable {

    String lockA;
    String lockB;

    public HoldThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {

        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有锁" + lockA + "尝试获得" + lockB);
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有锁" + lockB + "尝试获得" + lockA);
            }
        }
    }
}
