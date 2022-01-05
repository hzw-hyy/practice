package com.example.hyy.practice.leetcode;


/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author hyy
 * @version 1.0
 * @date 2020/7/7 11:26
 */
public class MergeOrderedArrays {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 > -1 && len2 > -1) {
            nums1[len--] = (nums1[len1] > nums2[len2]) ? nums1[len1--] : nums2[len2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }
}
