package com.example.hyy.practice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 问题：最近我在处理一批数据，用多线程来处理，我想知道大概多久能处理完。比如我先用多线程处理 100 条数据，统计下用时，然后根据总的数据量就可以大概估算出处理完这批数据要多久。
 * 解决：使使用线程池中方法计时。
 * 思路：线程池中提供了监控线程池运行的一些方法，这里通过线程池的 isTerminated() 方法不断检测，线程池中的任务是否都执行完成了，来获取所有任务结束时间。
 *
 * @author hyy
 * @version 1.0
 * @date 2020/7/29 11:26
 */
public class CalculateThreadTime2 {

    public static void main(String[] args) {

        new CalculateThreadTime2().orderPractice();
    }

    public void orderPractice() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " do something");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                long end = System.currentTimeMillis();
                System.out.println("time: " + (end - start) + "ms");
                break;
            }
        }
    }

}

