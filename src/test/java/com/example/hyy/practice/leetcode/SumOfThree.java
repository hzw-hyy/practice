package com.example.hyy.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * <p>
 * 首先对数组进行排序，排序后固定一个数 nums[i]
 * 再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L]和 nums[R]，
 * 计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
 * 如果 nums[i]大于 0，则后续置因为排序的原因都大于nums[i],则三数之和必然无法等于 0，结束循环
 * 如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
 * 当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
 * 当 sum == 0 时，nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R--
 * 时间复杂度：O(n^2)，n为数组长度
 * </p>
 *
 * @ClassName SumOfThree
 * @Author yggc
 * @Date 2021-9-10 6:21
 * @Description SumOfThree
 * @Version 1.0
 */
public class SumOfThree {

    public static void main(String[] args) {

        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1, j = nums.length - 1;
            if (nums[k] > 0) {
                break;
            }
            // 当k大于0时，所以k位置与k-1位置的数相同则说明重复，会导致结果集重复，所以略过。
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    /**
                     * 当sum等于0并且i/j位置与i+1/j-1位置的数相同时说明重复，会导致结果集重复，所以略过。
                     */
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                } else if (sum < 0) {
                    i++;
                } else if (sum > 0) {
                    j--;
                }
            }
        }
        return lists;
    }

}
