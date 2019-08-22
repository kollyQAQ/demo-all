package com.kolly.learning.proxy.cglibProxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @Author kolly
 * @Date 2018/4/12.li
 * Modified Logs:
 * Created by kolly.li on 2018/4/12.
 */
public class CglibProxyTest {

    public static void main(String[] args) {

        //设置将cglib生成的代理类字节码生成到指定位置
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/kolly/workspace-demo/demo-all");

        UserServiceCglib cglib = new UserServiceCglib();
        UserServiceImpl bookFacadeImpl = (UserServiceImpl) cglib.getInstance(new UserServiceImpl());
        bookFacadeImpl.addUser();
        System.out.println("-----分割线----");
        bookFacadeImpl.editUser();
    }

}
