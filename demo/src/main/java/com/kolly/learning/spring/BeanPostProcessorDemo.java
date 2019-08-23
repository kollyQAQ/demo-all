package com.kolly.learning.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019-08-23
 * <p>
 * BeanPostProcessor 接口是 Spring 对外拓展的接口之一，其主要用途提供一个机会，让开发人员能够插手 bean 的实例化过程。
 * 通过实现这个接口，我们就可在 bean 实例化时，对 bean 进行一些处理。
 * 比如，我们所熟悉的 AOP 就是在这里将切面逻辑织入相关 bean 中的。
 * 正是因为有了 BeanPostProcessor 接口作为桥梁，才使得 AOP 可以和 IOC 容器产生联系
 */
@Component
public class BeanPostProcessorDemo implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("footballPlayer")) {
            System.out.println("执行到 postProcessBeforeInitialization 方法，beanName:" + beanName);
        }
        return bean;
    }

    // 我们所熟知的 AOP 就是在这里将 Adivce 逻辑织入到 bean 中的
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("footballPlayer")) {
            System.out.println("执行到 postProcessAfterInitialization 方法，beanName:" + beanName);
        }
        return bean;
    }
}
