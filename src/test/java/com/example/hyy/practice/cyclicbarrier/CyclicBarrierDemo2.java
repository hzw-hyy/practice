package com.example.hyy.practice.cyclicbarrier;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 场景说明：
 * 模拟多线程分组计算
 * 有一个大小为50000的随机数组，用5个线程分别计算10000个元素的和
 * 然后在将计算结果进行合并，得出最后的结果。
 * 重点分析：
 * 用5个线程分别计算：定义一个大小为5的线程池。
 * 计算结果进行合并：定义一个屏障线程，将上面5个线程计算的子结果信息合并。
 *
 * @author hyy
 * @version 1.0
 * @date 2020/6/21 17:06
 */
public class CyclicBarrierDemo2 {

    //数组大小
    final static int size = 5000;

    public static void main(String[] args) throws InterruptedException {
        int[] ints = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            ints[i] = random.nextInt(1000);
        }
        // 单线程计算结果
        long startTime = new Date().getTime();
        sum(ints);
        long endTime = new Date().getTime();
        System.out.println("single time: " + (endTime - startTime));
        // 多线程计算结果
        long startTime1 = new Date().getTime();
        concurrentSum(ints);
        long endTime1 = new Date().getTime();
        System.out.println("multiple time: " + (endTime1 - startTime1));
    }

    public static void sum(int[] ints) throws InterruptedException {
        long sum = 0L;
        for (int i = 0; i < ints.length; i++) {
            TimeUnit.MILLISECONDS.sleep(1L);
            sum += ints[i];
        }
        System.out.println("single: " + sum);
    }

    public static void concurrentSum(int[] ints) {
        // 多线程计算结果
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 定义5个future去保存子数组计算结果
        final int[] results = new int[5];
        // 定义一个循环屏障,在屏障线程中进行计算结果合并
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            int sums = 0;
            for (int i = 0; i < 5; i++) {
                sums += results[i];
            }
            System.out.println("multiple: " + sums);
        });
        // 子数组长度
        final int length = size / 5;
        for (int i = 0; i < 5; i++) {
            int[] subNumbers = Arrays.copyOfRange(ints, (i * length), ((i + 1) * length));
            // 盛放计算结果
            int finalI = i;
            executorService.submit(() -> {
                for (int j = 0; j < subNumbers.length; j++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    results[finalI] += subNumbers[j];
                }
                //等待其他线程进行计算
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
