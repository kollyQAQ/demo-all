package com.kolly.learning.javabase.proxy.jdkProxy;

import com.kolly.learning.javabase.proxy.staticProxy.UserService;
import com.kolly.learning.javabase.proxy.staticProxy.UserServiceImpl;

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
        ServiceInvocationHandler handler = new ServiceInvocationHandler(userService);
        // 根据目标生成代理对象
        UserService proxy = (UserService) handler.getProxy();
        proxy.addUser();
        System.out.println("----------分割线----------");
        proxy.editUser();
        //System.out.println("----------分割线----------");
        //System.out.println(proxy.toString());

    }

}
