package com.kolly.learning.dubbo.spidemo;

import org.apache.dubbo.common.extension.SPI;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019-08-23
 */
@SPI
public interface Robot {
    void sayHello();
}



