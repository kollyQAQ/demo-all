package com.kolly.learning.base.reflact;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author kolly.li
 * @Date 2018/5/16
 * Modified Logs:
 * Created by kolly.li on 2018/5/16.
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        BaseClass bs = new ExtendsClass();
        bs.test();
    }

}
