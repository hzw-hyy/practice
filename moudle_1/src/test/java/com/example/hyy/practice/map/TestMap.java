package com.example.hyy.practice.map;

import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * HashMap在JDK1.8中并发操作，代码测试以及源码分析。
 * HashMap在JDK1.8中并发操作不会出现死循环，只会出现缺数据。测试如下：
 *
 * @author hyy
 * @version 1.0
 * @date 2020/8/11 11:05
 */
public class TestMap {

    /**
     * NUMBER = 10，表示十个线程执行put方法执行了十次
     * 也就是map中总共有10 * 10 = 100 条数据
     */
    static final int NUMBER = 10;
    static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(2);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER);
        for (int i = 0; i < NUMBER; i++) {
            executorService.execute(new A(map));
        }
        TimeUnit.SECONDS.sleep(1);
        int cnt = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            cnt++;
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        // 观察cnt的值是否等于插入的数量，就可以判断数据是否丢失了。
        System.out.println("cnt = " + cnt);
        executorService.shutdown();
    }
}

@AllArgsConstructor
class A implements Runnable {

    Map<String, String> map;

    @Override
    public void run() {
        for (int i = 0; i < TestMap.NUMBER; i++) {
            map.put(i + "   " + Thread.currentThread().getName(), "test");
        }
    }
}

