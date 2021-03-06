package com.kolly.learning.springdemo.ioc;

import com.kolly.learning.springdemo.Car;
import com.kolly.learning.springdemo.HelloService;
import com.kolly.learning.springdemo.Wheel;
import com.kolly.learning.springdemo.ioc.xml.XmlBeanFactory;
import org.junit.Test;

/**
 * Created by code4wt on 17/8/2.
 */
public class XmlBeanFactoryTest {

    @Test
    public void getBean() throws Exception {
        System.out.println("--------- IOC test ----------");
        String location = getClass().getClassLoader().getResource("toy-spring.xml").getFile();
        XmlBeanFactory bf = new XmlBeanFactory(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);

        System.out.println("\n--------- AOP test ----------");
        HelloService helloService = (HelloService) bf.getBean("helloService");
        helloService.sayHelloWorld();
    }
}