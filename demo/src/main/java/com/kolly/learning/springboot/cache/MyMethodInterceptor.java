package com.kolly.learning.springboot.cache;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019/7/1
 */
@Component
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        return invocation.proceed();
    }
}
