package com.example.hyy.practice.leetcode;

import java.util.*;

/**
 * 两数之和
 *
 * <p>
 * 思路
 * 标签：哈希映射
 * 这道题本身如果通过暴力遍历的话也是很容易解决的，时间复杂度在 O(n2)
 * 由于哈希查找的时间复杂度为 O(1)，所以可以利用哈希容器 map 降低时间复杂度
 * 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
 * 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
 * 如果最终都没有结果则抛出异常
 * 时间复杂度：O(n)
 * </p>
 *
 * @ClassName SumOfTwo
 * @Author 18845
 * @Date 2021/9/10 9:48
 * @Description SumOfTwo
 * @Version 1.0
 */
public class SumOfTwo {

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 11, 2, 15, 34, 13, 4, 54, 12, 5, 35, 26, 64, 24, 53, 23, 45, 23, 4, 3, 5, 2, 6, 26, 45, 22, 11, 52};
        List<List<Integer>> lists = twoSum(nums, 13);
        System.out.println(lists);
    }

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                lists.add(Arrays.asList(map.get(other), i));
            }
            map.put(nums[i], i);
        }
        return lists;
    }
}
