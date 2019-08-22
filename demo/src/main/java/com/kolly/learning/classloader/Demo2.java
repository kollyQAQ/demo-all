package com.kolly.learning.classloader;

/**
 * Created by kolly on 2017/10/29.
 */
public class Demo2 {

    public static void main(String[] args) {
        ClassLoader loader = Demo2.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }
        System.out.println(loader);
    }

}
