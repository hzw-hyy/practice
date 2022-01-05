package com.example.hyy.practice.jvm;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/7/9 14:58
 */
public class JvmDemo {
    public static void main(String[] args) throws InterruptedException {

//        System.out.println("hello world");
//        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        for (int i = 0; ; i++) {
//            TimeUnit.MILLISECONDS.sleep(1);
            objectObjectHashMap.put(i, new OOMObject());
//            System.out.println(objectObjectHashMap.toString());
        }
    }

    static class OOMObject {

    }
}
