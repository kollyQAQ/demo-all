package com.kolly.learning.algorithm;

/**
 * @Description 写一个函数，求两个整数的之和，要求在函数体内不得使用＋、－、×、÷
 * @Author kolly.li
 * @Date 2018/5/28
 */
public class AddWithoutArithmeticTest {

    private static int AddWithoutArithmetic(int num1, int num2) {
        if (num2 == 0)
            return num1;

        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;

        return AddWithoutArithmetic(sum, carry);
    }

    public static void main(String[] args) {
        System.out.println(AddWithoutArithmetic(12, 22));
    }
}
