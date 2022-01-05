package com.example.hyy.practice.thread.yield;

/**
 * 测试java.lang.Thread#yield()方法在放弃cpu时间片后，又重新竞争得到了执行权后继续执行的位置是重新走方法还是Thread.yield()方法后边。
 * 实验证明重新竞争得到了执行权后继续执行的位置是Thread.yield()方法后边而不是重新走run方法体。
 *
 * @ClassName TestYield
 * @Author yggc
 * @Date 2021-4-10 16:33
 * @Description TestYield
 * @Version 1.0
 */

public class TestYield {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA("A");
        ThreadA threadB = new ThreadA("B");
        // 设置优先级:MIN_PRIORITY最低优先级1;NORM_PRIORITY普通优先级5;MAX_PRIORITY最高优先级10
        threadA.setPriority(Thread.MAX_PRIORITY);
        threadB.setPriority(Thread.MIN_PRIORITY);
        threadA.start();
        threadB.start();
    }
}

class ThreadA extends Thread {

    private String t;

    public ThreadA(String t) {
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println(t + " " + Thread.currentThread().getName() + "-run");
        while (true) {
            System.out.println(t + " " + Thread.currentThread().getName() + "-while");
            if ("A".equalsIgnoreCase(t)) {
                Thread.yield();
                System.out.println(t + " " + Thread.currentThread().getName() + "-yield");
            }
        }
    }
}
