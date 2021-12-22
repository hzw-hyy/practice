package com.example.hyy.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/leetbook/read/array-and-string/y4dgi/
 *
 * @ClassName TestArray
 * @Author 18845
 * @Date 2021/12/3 17:15
 * @Description TestArray
 * @Version 1.0
 */
public class TestArray {
    /**
     * 寻找数组的中心索引
     *
     * @param nums
     * @return
     */
    public int findMiddleIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    /**
     * 寻找数组插入位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 合并区间
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        // 对二维数组按照第一列升序排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 结果集
        List<int[]> list = new ArrayList<>();
        // 临时空间，1.判断是否需要合并集合，2.是否放入结果集
        int term[] = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            if (term[1] >= intervals[i][0]) {
                term[1] = Math.max(term[1], intervals[i][1]);
            } else {
                list.add(term);
                term = intervals[i];
            }
        }
        list.add(term);
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * 旋转图像
     * 可以得知对于一个矩阵的元素matrix[row][col]在反转90度后它的位置为matrix[col][n-1-row]
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix_new[j][n - 1 - i] = matrix[i][j];

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }

    /**
     * 零矩阵
     *
     * @param matrixs
     */
    public void setZeroes(int[][] matrixs) {
        int m = matrixs.length;
        int n = matrixs[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < matrixs.length; i++) {
            for (int j = 0; j < matrixs[i].length; j++) {
                int matrix = matrixs[i][j];
                if (matrix == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < matrixs.length; i++) {
            for (int j = 0; j < matrixs[i].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrixs[i][j] = 0;
                }
            }
        }
    }
}
