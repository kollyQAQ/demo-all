package com.kolly.learning.reflact;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author kolly.li
 * @Date 2018/5/16
 * Modified Logs:
 * Created by kolly.li on 2018/5/16.
 */
public class BaseClass {

    public static final String str = "123";

    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = this.getClass().getMethod("getFieldOrderId", String.class);
        System.out.println(method.invoke(this, "ttt"));
    }
}
