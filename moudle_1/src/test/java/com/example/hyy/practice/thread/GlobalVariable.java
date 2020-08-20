package com.example.hyy.practice.thread;

/**
 * 全局变量在多线程中遇到使用不当的情况下会使各个线程之间受到影响。
 * 问题：当计数时，正常情况下我们想要各个线程之间的结果相互隔离，但是当多个线程共用一个对象时，计算的数会叠加到一起。
 * 解决：可以使用threadlocal或者将全局变量转换为局部变量。
 *
 * @author hyy
 * @version 1.0
 * @date 2020/7/29 10:03
 */
public class GlobalVariable {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            Count count = new Count();

            @Override
            public void run() {
//                count.count();
                count.countByThreadLocal();
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }
}

class Count {

    ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    private Integer countNum = 0;

    public void count() {

        for (int i = 0; i < 10; i++) {
            countNum++;
        }
        System.out.println("Thread.currentThread().getName()+\"-\"+countNum = " + Thread.currentThread().getName() + "-" + countNum);
    }

    public void countByThreadLocal() {

        for (int i = 0; i < 10; i++) {
            threadLocal.set(threadLocal.get() + 1);
        }
        System.out.println("Thread.currentThread().getName()+\"-\"+countNum = " + Thread.currentThread().getName() + "-" + threadLocal.get());
        threadLocal.remove();
    }
}
