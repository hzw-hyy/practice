package com.example.hyy.practice.thread.testWhile_demo;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/8/13 17:53
 */
public class Producer implements Runnable {


    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }
}
