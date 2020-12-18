package com.example.hyy.practice.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/10/15 10:52
 * <p>
 * 满足并发量读取共享资源应该同时执行。
 * 但是如果有一个线程想去写共享资源，就不应该有其他线程可以对资源进行读或写。
 * 读读共存
 * 读写不共存
 * 写写不共存
 * 写操作
 * 原子+独占 整个过程必须是一个完整的统一体，中间不允许被分割，被打断。
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp + "", temp);
            }, String.valueOf(temp)).start();
        }
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.get(finalI + "");
            }, String.valueOf(finalI)).start();
        }
        myCache.clearCache();
    }
}

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        reentrantReadWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Writing");
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " completed");
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public Object get(String key) {
        reentrantReadWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Reading");
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + " result: " + o);
            System.out.println(Thread.currentThread().getName() + " completed");
            return o;
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    public void clearCache() {
        map.clear();
    }
}
