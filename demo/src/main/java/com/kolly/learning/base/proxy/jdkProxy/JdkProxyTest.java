package com.kolly.learning.base.proxy.jdkProxy;

import com.kolly.learning.base.proxy.staticProxy.UserService;
import com.kolly.learning.base.proxy.staticProxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author kolly
 * @Date 2018/4/12.li
 * Modified Logs:
 * Created by kolly.li on 2018/4/12.
 */
public class JdkProxyTest {

    /**
     * jdk动态代理会生成一个动态代理类，生成相应的字节码，然后通过ClassLoader加载字节码。
     * 该实例继承了Proxy类，并实现了业务接口，在实现的方法里通过反射调用了InvocationHandler接口实现类
     * 的invoke()回调方法。
     *
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {

        //设置此系统属性,让JVM生成的Proxy类写入文件
        //生成的代理类自动保存在项目下的 com.sun.proxy 包内
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        UserService userService = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(userService);
        // 根据目标生成代理对象
        UserService proxy = (UserService) handler.getProxy();
        proxy.addUser();
        System.out.println("----------分割线----------");
        proxy.editUser();
        //System.out.println("----------分割线----------");
        //System.out.println(proxy.toString());

    }

    static class MyInvocationHandler implements InvocationHandler {

        // 目标对象
        private Object target;

        public MyInvocationHandler(Object target) {
            super();
            this.target = target;
        }

        /**
         * 创建代理实例
         */
        public Object getProxy() {
            /**
             * @param   loader the class loader to define the proxy class
             * @param   interfaces the list of interfaces for the proxy class
             *          to implement
             * @param   h the invocation handler to dispatch method invocations to
             * @return a proxy instance with the specified invocation handler of a
             *          proxy class that is defined by the specified class loader
             *          and that implements the specified interfaces
             */
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), this.target.getClass().getInterfaces(), this);
            // 这样写只返回了目标对象，没有生成代理对象。
            // return target;
        }

        /**
         * 实现InvocationHandler接口方法
         * 执行目标对象的方法，并进行增强
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            Object result = null;
            System.out.println("代理类方法，进行了增强。。。");
            System.out.println("事务开始。。。");
            // 执行目标方法对象
            result = method.invoke(target, args);
            System.out.println("事务结束。。。");
            return result;
        }

    }

}
