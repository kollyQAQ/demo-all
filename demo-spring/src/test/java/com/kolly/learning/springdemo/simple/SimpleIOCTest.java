package com.kolly.learning.springdemo.simple;

import com.kolly.learning.springdemo.Car;
import com.kolly.learning.springdemo.Wheel;
import org.junit.Test;

/**
 * Created by code4wt on 17/8/19.
 */
public class SimpleIOCTest {

    @Test
    public void getBean() throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("toy-spring-ioc.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
    }
}