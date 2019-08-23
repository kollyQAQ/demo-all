package com.kolly.learning.dubbo;

import com.kolly.learning.dubbo.spidemo.Robot;
import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019-08-23
 */
public class JavaSPITest {

    @Test
    public void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
