package com.example.hyy.practice.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName SmallestNumberOfK
 * @Author yggc
 * @Date 2021-12-4 10:49
 * @Description SmallestNumberOfK
 * @Version 1.0
 */
public class SmallestNumberOfK {

    /**
     * 大顶堆
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);

        for (int i : arr) {
            if (queue.size() < k) {
                queue.offer(i);
            } else if (i < queue.peek()) {
                queue.poll();
                queue.offer(i);
            }
        }

        int[] ints = new int[k];
        int idx = 0;
        for (int anInt : queue) {
            ints[idx++] = anInt;
        }
        return ints;
    }

    @Test
    public void testquickSort() {
//        int[] arr = new int[]{1,4,5,2,6,7,3,9,8};
        int[] arr = new int[]{0, 1, 2, 1};
        int[] smallestNumberOfK = getSmallestNumberOfK(arr, 1);
        System.out.println("smallestNumberOfK = " + smallestNumberOfK);
    }

    /**
     * 快速排序解法
     *
     * @param arr 被操作数组
     * @param k   最小的k个数
     * @return 被处理后的数组，前k+1个数（0-k）是数组中最小的k+1个数
     */
    public int[] getSmallestNumberOfK(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        int h = arr.length - 1;
        return quickSort(arr, 0, h, k - 1);
    }

    /**
     * 划分数组，寻找前k个数
     *
     * @param arr 被操作数组
     * @param l   左指针下标
     * @param h   右指针下标
     * @param k   指定下标
     * @return 被处理后的数组，前k+1个数（0-k）是数组中最小的k+1个数
     */
    public int[] quickSort(int[] arr, int l, int h, int k) {
        int i = partition(arr, l, h);
        if (i == k) {
            return Arrays.copyOf(arr, i + 1);
        }
        return i > k ? quickSort(arr, l, i - 1, k) : quickSort(arr, i + 1, h, k);
    }

    /**
     * 划分数组，使数组被划分成一个小于枢纽元v的数组和大于枢纽元v的数组
     *
     * @param arr 被操作数组
     * @param l   左指针下标
     * @param h   右指针下标
     * @return 枢纽元下标
     */
    public int partition(int[] arr, int l, int h) {
        if (l == h) {
            return l;
        }
        int v = median3(arr, l, h);
        int i = l;
        int j = h - 1;
        while (true) {
            while (++i < h - 1 && arr[i] < v) ;
            while (--j > l && arr[j] > v) ;
            if (i >= j) {
                break;
            }
            swapReferences(arr, i, j);
        }
        swapReferences(arr, i, h - 1);
        return i;
    }

    /**
     * 获取枢纽元
     * <p>
     * 将数组中前，中，后三个下标的数进行升序排序，使得这三个位置的数（l,(l+h)/2,h）确保是升序的。
     * <p>
     * 在排序后将数组中间的数与h-1下标的数进行交换，以便将待操作的数变为连续的，排序后的数组：
     * 【l】-?-?-?-【h-1】-?-?-?-【(l+h)/2】-【h】
     *
     * @param arr 被操作数组
     * @param l   左指针下标
     * @param h   右指针下标
     * @return 枢纽元
     */
    private Integer median3(int[] arr, int l, int h) {
        int center = (l + h) / 2;
        if (arr[center] < arr[l]) {
            swapReferences(arr, l, center);
        }
        if (arr[h] < arr[l]) {
            swapReferences(arr, l, h);
        }
        if (arr[h] < arr[center]) {
            swapReferences(arr, center, h);
        }
        swapReferences(arr, center, h - 1);
        return arr[h - 1];
    }

    /**
     * 交换两个数
     *
     * @param arr 被操作数组
     * @param x   一个数
     * @param y   一个数
     */
    public void swapReferences(int[] arr, int x, int y) {
        int temp;
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
