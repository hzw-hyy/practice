package com.example.hyy.practice.leetcode;

import org.omg.CORBA.CharHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestE {

    /**
     * 合并有序两个数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeNums(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 > -1 && len2 > -1) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public Node mergeLinks(Node l1, Node l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeLinks(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeLinks(l2.next, l1);
            return l2;
        }
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 查找最长不重复子字符串
     * 滑动窗口算法
     *
     * @param s
     * @return
     */
    public int longestNnRepeatingSubstring(String s) {
        int n = s.length(), ans = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            char c = s.charAt(end);
            if (hashMap.containsKey(c)) {
                start = Math.max(hashMap.get(c), start);
            }
            ans = Math.max(end - start + 1, ans);
            hashMap.put(c, end + 1);
        }
        return ans;
    }

    /**
     * 多数元素
     *
     * @param nums
     * @return
     */
    public int countNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    /**
     * 多数元素
     * 投票算法
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cand_num == nums[i]) {
                ++count;
            } else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }

}
