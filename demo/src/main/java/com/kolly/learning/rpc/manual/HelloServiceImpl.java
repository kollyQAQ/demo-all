package com.kolly.learning.rpc.manual;

/**
 * @Author kolly
 * @Date 2018/4/10
 * Modified Logs:
 * Created by kolly on 2018/4/10.
 */
public class HelloServiceImpl implements HelloService {

    public String hello(String name) {
        return "Hello " + name;
    }
}
