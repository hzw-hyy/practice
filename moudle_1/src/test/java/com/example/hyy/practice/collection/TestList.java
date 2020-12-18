package com.example.hyy.practice.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/9/25 15:15
 */
public class TestList {

    public static void main(String[] args) {
        testConcurrentModificationException();
    }

    //    @Test
    static void testConcurrentModificationException() {
        List<String> lists = new ArrayList();
//        ExecutorService executorService = Executors.newFixedThreadPool(50);
        try {
            for (int i = 0; i < 500; i++) {
//                executorService.submit(() -> {
                new Thread(() -> {

                    String s = UUID.randomUUID().toString();
                    String substring = s.substring(1, 8);
                    lists.add(substring);
                    System.out.println(Thread.currentThread().getName() + ": " + lists);
                }).start();
//                });
            }
        } finally {
//            executorService.shutdown();
        }
    }
}