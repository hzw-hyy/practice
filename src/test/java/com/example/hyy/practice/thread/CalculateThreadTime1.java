package com.example.hyy.practice.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 问题：最近我在处理一批数据，用多线程来处理，我想知道大概多久能处理完。比如我先用多线程处理 100 条数据，统计下用时，然后根据总的数据量就可以大概估算出处理完这批数据要多久。
 * 解决：使用 CountDownLatch 计时。
 * 思路：用两个 CountDownLatch 倒计时锁：开始计时锁，任务结束计时锁。开始计时锁在子线程任务开始时通过 await() 阻塞所有子线程，然后在主线程中通过 CountDownLatch 控制所有子线程同时开始获取开始时间；任务结束计时锁 CountDownLatch 在每个子线程执行完后都 countDown 一次，直到所有子线程执行完，主线程开始记录所有任务执行结束时间。
 *
 * @author hyy
 * @version 1.0
 * @date 2020/7/29 11:26
 */
public class CalculateThreadTime1 {

    private int nThread;
    private CountDownLatch startGate;
    private CountDownLatch endGate;

    public CalculateThreadTime1(int nThread, CountDownLatch startGate, CountDownLatch endGate) {
        this.nThread = nThread;
        this.startGate = startGate;
        this.endGate = endGate;
    }

    public static void main(String[] args) {
        int nThread = 5;
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch endGate = new CountDownLatch(nThread);
        new CalculateThreadTime1(nThread, startGate, endGate).timeTasks();
    }

    public long timeTasks() {
        for (int i = 0; i < nThread; i++) {
            Thread thread = new Thread(new worker());
            thread.start();
        }
        long start = System.currentTimeMillis();
        try {
            // 所有阻塞的任务同时开始
            startGate.countDown();
            // 主线程阻塞，等待其他所有worker线程完成后再执行
            endGate.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start) + "ms");
        return end - start;
    }

    class worker implements Runnable {

        @Override
        public void run() {
            try {
                startGate.await();
                Random random = new Random();
                int num = random.nextInt(500) + 500;
                System.out.println(Thread.currentThread().getName() + " start and sleep: " + num + "ms");
                Thread.sleep(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                endGate.countDown();
            }
        }
    }

}

