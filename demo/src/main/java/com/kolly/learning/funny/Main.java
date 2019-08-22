package com.kolly.learning.funny;

/**
 * Created by kolly on 2017/10/29.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(int.class);

        Class clazz = (new int[3][4][5][6][7][8][9]).getClass();
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
    }

}
