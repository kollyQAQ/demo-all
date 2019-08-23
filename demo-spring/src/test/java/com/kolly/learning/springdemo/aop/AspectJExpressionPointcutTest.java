package com.kolly.learning.springdemo.aop;

import com.kolly.learning.springdemo.HelloService;
import com.kolly.learning.springdemo.HelloServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by code4wt on 17/8/17.
 */
public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(* com.kolly.learning.springdemo.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.matchers(HelloService.class);
        assertTrue(matches);
    }

    @Test
    public void testMethodMatcher() throws Exception {
        String expression = "execution(* com.kolly.learning.springdemo.*.sayHelloWorld(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.matchers(
                HelloServiceImpl.class.getDeclaredMethod("sayHelloWorld"), HelloServiceImpl.class);
        assertTrue(matches);
    }
}