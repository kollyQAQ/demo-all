package com.kolly.learning.base.staticStudy;

/**
 * Created by kolly on 2017/10/29.
 */
public class Demo {

    public static int tmp = 1;

    static {
        tmp = 2;
        System.out.println(tmp);
    }
    //如果把tmp放入static块后面，则只能写，不能读
    //public static int tmp = 1;

    public static void main(String[] args) {
        tmp = 3;
        System.out.println(tmp);
    }

}
