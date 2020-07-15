package com.example.hyy.practice.thread;

/**
 * java子线程中获取父线程的threadLocal中的值
 * 我们都知道线程本地变量表也就是ThreadLocal在我们做线程级的数据隔离时非常好用，
 * 但是有时候我们会想如何让子线程获取到父线程的ThreadLocal，
 * 其实在线程中除了ThreadLocal外还有InheritableThreadLocal，
 * 顾名思义，可继承的线程变量表，可以让子线程获取到父线程中ThreadLocal的值。
 *
 * @author hyy
 * @version 1.0
 * @date 2020/7/3 18:14
 */
public class InheritableThreadlocalDemo {

    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static final InheritableThreadLocal<String> inheritable_threadlocal = new InheritableThreadLocal<>();

    /**
     * main线程是主线程。
     *
     * @param args
     */
    public static void main(String[] args) {
        inheritable_threadlocal.set("inheritable_threadlocal hello");
        threadLocal.set("threadlocal hello");

        System.out.println("threadLocal中子线程可继承值: " + threadLocal.get());
        System.out.println("inheritable_threadlocal中子线程可继承值: " + inheritable_threadlocal.get());
        // 此AAA线程是子线程。
        new Thread(() -> {
            System.out.println("threadLocal中子线程可继承值: " + threadLocal.get());
            System.out.println("inheritable_threadlocal中子线程可继承值: " + inheritable_threadlocal.get());
            // 此BBB线程是孙子线程。
            new Thread(() -> {

                System.out.println("threadLocal中子线程可继承值: " + threadLocal.get());
                System.out.println("inheritable_threadlocal中子线程可继承值: " + inheritable_threadlocal.get());

            }, "BBB").start();
        }, "AAA").start();
    }

}
