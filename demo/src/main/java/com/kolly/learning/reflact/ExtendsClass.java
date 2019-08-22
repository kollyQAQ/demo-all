package com.kolly.learning.reflact;

import java.lang.reflect.Field;

/**
 * @Author kolly.li
 * @Date 2018/5/16
 * Modified Logs:
 * Created by kolly.li on 2018/5/16.
 */
public class ExtendsClass extends BaseClass {

    public String cal(String a) {
        return a + a;
    }

    public String getFieldOrderId(String a) {
        return a + a;
    }

    public static void main(String[] args) throws Exception {
        ExtendsClass extendsClass = new ExtendsClass();
        Field f = SuperClassReflectionUtils.getDeclaredField(extendsClass, "str");
        System.out.println(f.get(extendsClass));
    }
}
