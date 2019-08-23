package com.kolly.learning.springdemo.aop;

/**
 * @author yihua.huang@dianping.com
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
