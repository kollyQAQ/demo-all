package com.kolly.learning.springdemo.aop;

/**
 * Created by code4wt on 17/8/16.
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
