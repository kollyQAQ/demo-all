package com.kolly.learning.jvm.classloader;

/**
 * Created by kolly on 2017/10/29.
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }
        System.out.println(loader);
    }

}
