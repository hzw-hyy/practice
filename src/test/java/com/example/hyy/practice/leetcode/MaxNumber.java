package com.example.hyy.practice.leetcode;

import java.util.Arrays;

/**
 * @ClassName MaxNumber
 * @Author 18845
 * @Date 2021/12/2 20:45
 * @Description MaxNumber
 * @Version 1.0
 */
public class MaxNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 1000,100};
        String max = getMaxStr(nums);
        System.out.println("Max:" + max);
    }

    public static String getMaxStr(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            stringBuffer.append(strs[i]);
        }
        return stringBuffer.toString();
    }
}
