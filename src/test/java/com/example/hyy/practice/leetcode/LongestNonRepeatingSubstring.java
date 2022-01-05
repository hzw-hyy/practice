package com.example.hyy.practice.leetcode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class LongestNonRepeatingSubstring {

    public int lengthOfLongestSubstring(String s) {
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
}
