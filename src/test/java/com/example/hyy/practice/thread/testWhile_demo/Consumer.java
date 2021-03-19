package com.example.hyy.practice.thread.testWhile_demo;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/8/13 17:59
 */
public class Consumer implements Runnable {

    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.get();
        }
    }
}
