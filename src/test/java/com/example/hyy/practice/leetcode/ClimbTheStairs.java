package com.example.hyy.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯 => 不允许到达7的倍数层 => 优化为线性(不能使用动态规划)
 *
 * @author 18845
 */
public class ClimbTheStairs {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap();
        int val = climbStairs(9, map);
        System.out.println(val);
    }

    public static int climbStairs(int n, Map<Integer, Integer> map) {
        if (n < 1) {
            System.out.println(n + "_" + 0);
            return 0;
        }
        if (n == 1) {
            System.out.println(n + "_" + 1);
            return 1;
        }
        if (n == 2) {
            System.out.println(n + "_" + 2);
            return 2;
        }
        if ((n % 7) == 0) {
            System.out.println(n + "_" + 0);
            return 0;
        }
        if (map.containsKey(n)) {
            System.out.println("map_" + n + "_" + map.get(n));
            return map.get(n);
        } else {
            int val;
            if ((n - 1) % 7 == 0) {
                val = climbStairs(n - 2, map);
                map.put(n, val);
                System.out.println(n + "_" + val);
                return val;
            }
            if ((n - 2) % 7 == 0) {
                val = climbStairs(n - 1, map);
                map.put(n, val);
                System.out.println(n + "_" + val);
                return val;
            }
            val = climbStairs(n - 1, map) + climbStairs(n - 2, map);
            map.put(n, val);
            System.out.println(n + "_" + val);
            return val;
        }
    }
}