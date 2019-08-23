package com.kolly.learning.algorithm;

import java.util.Arrays;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019-08-22
 * <p>
 * 数组A，2*n个元素，n个奇数、n个偶数，设计一个算法，使得数组奇数下标位置放置的都是奇数，偶数下标位置放置的都是偶数
 */
public class Demo {

    public static void main(String[] args) {
        int[] arr = {1, 3, 12, 2, 4, 5, 8, 10, 7, 6, 9, 11};
        int i = 0, j = 1;// i - 偶数下标指针 1 - 奇数下标指针
        int length = arr.length;
        while (i < length && j < length) {
            while (i < length && arr[i] % 2 == 0) {
                i += 2;
            }
            while (j < length && arr[j] % 2 == 1) {
                j += 2;
            }
            //if (i < length && j < length)
            swap(arr, i, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
