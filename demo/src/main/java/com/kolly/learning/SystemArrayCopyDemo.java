package com.kolly.learning.learning;

import java.util.Arrays;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019-08-17
 * <p>
 * 本地方法 System.arraycopy 实现数组拷贝，ArrayList 源码中大量使用此方法
 */
public class SystemArrayCopyDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        // 打印结果：[1, 2, 3, 4, 5, 6, 7, 8]
        System.out.println(Arrays.toString(arr));
        // 参数含义以此为：源数组，源数组开始位置，目标数组，目标数组开始位置，待拷贝元素数量
        System.arraycopy(arr, 2, arr, 3, 5);
        // 打印结果：[1, 2, 3, 3, 4, 5, 6, 7]，注意索引 2 的元素没有被删除
        System.out.println(Arrays.toString(arr));
    }
}
