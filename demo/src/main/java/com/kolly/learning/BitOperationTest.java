package com.kolly.learning.learning;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019-08-21
 * <p>
 * ~：代表位取反，&：代表位与，|：代表位或，^：代表位异或
 * >>：代表算术右移，<<：代表算术左移，">>>：代表逻辑右移
 * >>>：无符号右移，忽略符号位，空位都以0补齐
 */
public class BitOperationTest {

    public static void main(String[] args) {
        /**
         * HashMap 判断当前元素存放的桶的位置的方法
         *
         * 如何 n 是 2 的次方，那么 (n - 1) & hash 相当于 hash % n 的取模运算，但是位运算效率更高
         */
        int n = 16, hash1 = 18, hash2 = 32;
        System.out.println((n - 1) & hash1); // output: 2
        System.out.println((n - 1) & hash2); // output: 0
        System.out.println("=============================");

        /**
         * HashMap 通过 key 的 hashCode 经过扰动函数处理过后得到 hash 值
         *
         * 所谓扰动函数指的就是 HashMap 的 hash 方法。使用 hash 方法也就是扰动函数是为了防止一些
         * 实现比较差的 hashCode() 方法 换句话说使用扰动函数之后可以减少碰撞  why？？？？
         *
         * static final int hash(Object key) {
         *       int h;
         *       // key.hashCode()：返回散列值也就是hashcode
         *       // ^ ：按位异或
         *       // >>>:无符号右移，忽略符号位，空位都以0补齐
         *       return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
         *   }
         *
         */
        int h1 = 100, h2 = 100000;
        System.out.println(h1 >>> 16); // output: 0
        System.out.println(h1 ^ (h1 >>> 16)); // output: 100
        System.out.println(h2 >>> 16); // output: 1
        System.out.println(h2 ^ (h2 >>> 16)); // output: 100001
        System.out.println("=============================");
    }
}
