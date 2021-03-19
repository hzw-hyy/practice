package com.example.hyy.practice.map;

import java.util.HashMap;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/8/13 18:36
 */
public class Key implements Comparable<Key> {

    public static final int MAX_KEY = 10_000_000;
    private static final Key[] KEYS_CACHE = new Key[MAX_KEY];

    static {
        for (int i = 0; i < MAX_KEY; i++) {
            KEYS_CACHE[i] = new Key(i);
        }
    }

    private final int value;

    public Key(int value) {
        this.value = value;
    }

    public static Key of(int value) {
        return KEYS_CACHE[value];
    }

    static void test(int mapSize) {
        HashMap<Key, Integer> map = new HashMap<>(mapSize);
        for (int i = 0; i < mapSize; i++) {
            map.put(Key.of(i), i);
        }
        long beginTime = System.nanoTime(); //获取纳秒
        for (int i = 0; i < mapSize; i++) {
            map.get(Key.of(i));
        }
        long endTime = System.nanoTime();
        System.out.println((endTime - beginTime) / 1000);
    }

    public static void main(String[] args) {
//        for (int i = 10; i < MAX_KEY; i *= 10) {
//            test(i);
//        }

        for (int i = 0; i < 10; ++i) {
            System.out.println("i = " + i);
        }
    }

    @Override
    public int compareTo(Key o) {
        return Integer.compare(this.value, o.value);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Key key = (Key) obj;
        return value == key.value;
    }
}

