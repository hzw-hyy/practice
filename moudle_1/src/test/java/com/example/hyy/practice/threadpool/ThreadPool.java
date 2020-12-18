package com.example.hyy.practice.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 *
 * @author hyy
 * @version 1.0
 * @date 2020/9/25 15:15
 */
public class ThreadPool {

    public static void main(String[] args) {
        testThreadPool();
    }

    static void testThreadPool() {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                // 四种不同的拒绝策略，结果也不一样。
                new ThreadPoolExecutor.DiscardPolicy()
//                new ThreadPoolExecutor.AbortPolicy();
//                new ThreadPoolExecutor.CallerRunsPolicy();
//                new ThreadPoolExecutor.DiscardOldestPolicy();
        );
        try {
            for (int i = 0; i < 10; i++) {
                executorService.submit(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } finally {
            executorService.shutdown();
        }
    }
}