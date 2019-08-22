package com.kolly.learning.rpc.dubbo.proxy;

/**
 * @Author kolly
 * @Date 2018/4/12.li
 * Modified Logs:
 * Created by kolly.li on 2018/4/12.
 */
public class DubboTest {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new com.kolly.learning.rpc.dubbo.proxy.MenuServiceImpl());
        com.kolly.learning.rpc.dubbo.proxy.MenuService menuService = proxyFactory.getProxyObject();
        menuService.sayHello();
    }
}
