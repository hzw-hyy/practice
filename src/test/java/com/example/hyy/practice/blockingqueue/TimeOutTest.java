package com.example.hyy.practice.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/6/27 17:14
 */
public class TimeOutTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);
        try {
            arrayBlockingQueue.offer("1");
            arrayBlockingQueue.offer("2");
            System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
            System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
            Thread.sleep(1000);
//            arrayBlockingQueue.offer("3");
            System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
