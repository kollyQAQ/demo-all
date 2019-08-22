package com.kolly.learning.spi.impl;

import com.kolly.learning.spi.ISayName;

/**
 * @Author kolly
 * @Date 2018/4/12.li
 * Modified Logs:
 * Created by kolly.li on 2018/4/12.
 */
public class SayChineseName implements ISayName {
    public void say() {
        System.out.println("李俊超");
    }
}
