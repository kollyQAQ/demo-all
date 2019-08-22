package com.kolly.learning.proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用Cglib动态代理
 *
 * @Author kolly
 * @Date 2018/4/12.li
 * Modified Logs:
 * Created by kolly.li on 2018/4/12.
 */
public class UserServiceCglib implements MethodInterceptor {

    private Object target;

    /**
     * 创建代理实例
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 设置回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    /**
     * 实现MethodInterceptor接口要重写的方法。
     * 回调方法
     */
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("事务开始。。。");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("事务结束。。。");
        return result;
    }

}