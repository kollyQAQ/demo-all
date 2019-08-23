package com.kolly.learning.springdemo.aop;

import com.kolly.learning.springdemo.HelloService;
import com.kolly.learning.springdemo.HelloServiceImpl;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by code4wt on 17/8/17.
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void getProxy() throws Exception {
        System.out.println("---------- no proxy ----------");
        HelloService helloService = new HelloServiceImpl();
        helloService.sayHelloWorld();

        System.out.println("\n----------- proxy -----------");
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setMethodInterceptor(new LogInterceptor());

        TargetSource targetSource = new TargetSource(
                helloService, HelloServiceImpl.class, HelloServiceImpl.class.getInterfaces());
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodMatcher((Method method, Class beanClass) -> true);

        helloService = (HelloService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        helloService.sayHelloWorld();
    }
}