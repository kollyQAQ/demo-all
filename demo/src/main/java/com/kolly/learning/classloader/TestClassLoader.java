package com.kolly.learning.classloader;

/**
 * Created by kolly on 2017/10/29.
 */
public class TestClassLoader {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader = new MyClassLoader(null, "d:/tmp/", "landy");
        Class<?> c = loader.loadClass("Main");
        c.newInstance();
    }
}
