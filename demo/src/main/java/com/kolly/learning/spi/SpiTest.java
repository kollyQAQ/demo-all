package com.kolly.learning.spi;

import com.sun.tools.javac.util.ServiceLoader;

/**
 * @Author kolly
 * @Date 2018/4/12.li
 * Modified Logs:
 * Created by kolly.li on 2018/4/12.
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<ISayName> loaders = ServiceLoader.load(ISayName.class);
        for (ISayName sayName : loaders) {
            sayName.say();
        }
    }
}
