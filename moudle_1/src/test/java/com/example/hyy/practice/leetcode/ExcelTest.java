package com.example.hyy.practice.leetcode;

/**
 * java 实现生成excel表头，A-Z;AA-ZZ;AAA-ZZZ支持无限
 *
 * @author hyy
 * @version 1.0
 * @date 2020/10/31 11:23
 */
public class ExcelTest {

    public static void main(String[] args) {
        System.out.println(getKey(1000));
    }

    public static String getKey(int index) {
        String colCode = "";
        char key = 'A';
        int loop = index / 26;
        if (loop > 0) {
            colCode += getKey(loop - 1);
        }
        key = (char) (key + index % 26);
        colCode += key;
        return colCode;
    }

}
