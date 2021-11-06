package com.example.hyy.practice.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，
 * 请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 * @author hyy
 * @version 1.0
 * @date 2020/7/7 11:26
 */
public class MergeOrderedArrays {


    @Test
    public int merge(int[] nums1, int[] nums2) {

        // two get pointers for nums1 and nums2;
        int p1 = nums1.length - 1;
        int p2 = nums2.length - 1;
        // set pointer for nums1;
        int p = nums1.length + nums2.length - 1;
        // while there are still elements to compare
        while (p1 > -1 && p2 > -1)
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        return 1;
    }
}
