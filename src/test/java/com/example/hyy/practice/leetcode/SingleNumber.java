package com.example.hyy.practice.leetcode;

/**
 * 137.只出现一次的数字 Ⅱ
 * <p>
 * 一个整数数组 nums ，除某个元素仅出现一次外，其余每个元素都恰出现三次，请你找出并返回那个只出现了一次的元素。
 * 解题思路：
 *
 * @ClassName SingleNumber
 * @Author 18845
 * @Date 2021/9/15 14:49
 * @Description SingleNumber
 * @Version 1.0
 */
public class SingleNumber {

    public static void main(String[] args) {
        int nums[] = {3, 3, 5, 3};
        int result = singleNumber(nums);
        System.out.println(result);
    }

    public static int singleNumber(int[] nums) {

        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
