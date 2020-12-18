package com.example.hyy.practice.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程通信之生产者消费者阻塞队列版
 *
 * @author hyy
 * @version 1.0
 * @date 2020/6/25 16:12
 */
public class ProdConsumer_BlockingQueueDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t prod start success.");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t consumer start success.");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5s later,main thread end");
        try {
            myResource.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyResource {
    BlockingQueue<String> blockingQueue = null;
    private volatile boolean flag = true;//默认开启，进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    // 生产者
    public void myProd() throws Exception {
        String data = null;
        boolean returnVal;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            returnVal = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (returnVal)
                System.out.println(Thread.currentThread().getName() + "\t offer " + data + " success ");
            else
                System.out.println(Thread.currentThread().getName() + "\t offer " + data + " false ");
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t prod end");
    }

    // 消费者
    public void myConsumer() throws Exception {

        String result = null;
        while (flag) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t out 2s,consumer end");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t poll " + result + " success ");
        }
    }

    public void stop() throws Exception {
        this.flag = false;
    }
}