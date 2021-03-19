package com.example.hyy.practice.sort;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * 快速排序
 *
 * @author xq
 */
public class QuickSort {
    /**
     * Return median of left,center,and right. Order these and hide the pivot
     *
     * @param a
     * @param left
     * @param right
     * @return
     */

    static int count = 0;

    public static void main(String[] args) {

        Integer[] a = new Integer[]{8, 1, 4, 9, 0, 3, 5, 2};
        // , 7, 6, 8, 1, 4, 9, 0, 3, 5, 2, 7, 6, 8, 1, 4, 9, 0, 3, 5,
        // 2, 7, 6, 8, 1, 4, 9, 0, 3, 5, 2, 7, 6, 8, 1, 4, 9, 0, 3, 5, 2, 7, 6,
        // 8, 1, 4, 9, 0, 3, 5, 2, 7, 6 };
        quickSort(a, 0, a.length - 1);
        System.out.println("over比較次數" + count);
    }

    public static Integer[] getRanDomNum(int n) {
        Integer[] arr = new Integer[n];
        // java.util.Scanner sc = new java.util.Scanner(System.in);
        // System.out.println("请输入，只能为数字");
        try {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (new Random().nextInt(1000) + 1);
            }
            // System.out.println(Arrays.toString(arr));
        } catch (Exception e) {
            System.err.println("输入有误!");
        }
        // int number = (int) ((Math.random() * 9 + 1) * 100000);
        // System.out.println(number);
        return arr;
    }

    private static Integer median3(Integer[] a, int left, int right) {

        int center = (left + right) / 2;
        if (a[center].compareTo(a[left]) < 0) {
            count++;
            swapReferences(a, left, center);
        }
        if (a[right].compareTo(a[left]) < 0) {
            count++;
            swapReferences(a, left, right);
        }
        if (a[right].compareTo(a[center]) < 0) {
            count++;
            swapReferences(a, center, right);
        }
        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    public static void quickSort(Integer[] a, int left, int right) {

        while (left >= right) {
            // System.out.println("dj");
            return;
        }
        if (right - left <= 2)
            median3(a, left, right);
        else {
            Integer pivot = median3(a, left, right);
            int i = left;
            int j = right - 1;
            for (; ; ) {
                while (a[++i].compareTo(pivot) < 0) {
                    count++;
                }
                while (a[--j].compareTo(pivot) > 0) {
                    count++;
                }
                // 定義界限因爲median3方法，所以a[left]一定小於樞紐元，a[right]一定大於樞紐元，則i的範圍為下角標為left到right-1,同理則j的範圍為下角標為left-1到right。
                if (i < j && i < right && j > left)
                    swapReferences(a, i, j);
                else
                    break;

            }
            swapReferences(a, i, right - 1);
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);

        }
    }

    public static void swapReferences(Integer[] a, int x, int y) {
        int temp;
        temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    @Test
    public void testquickSort() {
        Integer[] a;
        double z = (Math.pow(2, 8) + 1);
        // System.out.println(z);
        for (int i = 2; i < z; i = i * 2) {
            a = getRanDomNum(i);
//            System.out.println(Arrays.toString(a));
            Long beginTime = System.currentTimeMillis();// date.getTime();
//            System.out.println(beginTime);
            this.quickSort(a, 0, a.length - 1);
            Long endTime = System.currentTimeMillis();
//            System.out.println(endTime);
            System.out.println("数组长度：" + i);
            System.out.println("over比較次數:" + count);
            System.out.println("计算时间：" + (endTime - beginTime));
//            System.out.println(Arrays.toString(a));
            System.out.println();
        }

        System.out.println("over");
    }
}
