package com.example.hyy.practice.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/10/15 9:40
 * <p>
 * 实现一个自旋锁
 * 自旋锁的好处：没有阻塞的情况。
 * 通过CAS操作完成自旋锁，A线程先调用mylock方法自己持有锁5s，B线程调用mylock方法发现其他线程持有锁，所以通过只能自旋等待，直到其他线程释放后B才能抢到。
 */
public class SpinLockPractice {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        SpinLock spinLock = new SpinLock();

        executorService.execute(() -> {
            spinLock.mylock();
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.myUnlock();
        });
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.execute(() -> {
            spinLock.mylock();

            spinLock.myUnlock();
        });
        executorService.shutdown();
    }
}

class SpinLock {

    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void mylock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " come in");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myUnlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.getName() + " come out");
    }

}
