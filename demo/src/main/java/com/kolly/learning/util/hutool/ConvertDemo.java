package com.kolly.learning.util.hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;

import java.util.List;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019-08-22
 */
public class ConvertDemo {

    public static void main(String[] args) {
        Object[] a = {"a", "你", "好", "", 1};
        List<String> list = Convert.convert(new TypeReference<List<String>>() {
        }, a);
        System.out.println(list);
    }
}
