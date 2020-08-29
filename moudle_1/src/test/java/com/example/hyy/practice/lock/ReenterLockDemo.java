package com.example.hyy.practice.lock;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/8/25 9:58
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}

class Phone {

    public synchronized void sendSms() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\tsendSms");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\tsendEmail");
    }
}
