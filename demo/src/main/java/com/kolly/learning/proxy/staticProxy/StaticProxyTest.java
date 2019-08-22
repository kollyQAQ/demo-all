package com.kolly.learning.proxy.staticProxy;

/**
 * @Author kolly
 * @Date 2018/4/12.li
 * Modified Logs:
 * Created by kolly.li on 2018/4/12.
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        UserServiceImpl userImpl = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy(userImpl);
        proxy.addUser();
        System.out.println("----------分割线----------");
        proxy.editUser();
    }

    /**
     * 静态代理类，需要显示的实现一个类
     */
    static class UserServiceProxy implements UserService {

        private UserServiceImpl userImpl;

        public UserServiceProxy(UserServiceImpl countImpl) {
            this.userImpl = countImpl;
        }

        @Override
        public void addUser() {
            System.out.println("代理类方法，进行了增强。。。");
            System.out.println("事务开始。。。");
            // 调用委托类的方法;
            userImpl.addUser();
            System.out.println("处理结束。。。");
        }

        @Override
        public void editUser() {
            System.out.println("代理类方法，进行了增强。。。");
            System.out.println("事务开始。。。");
            // 调用委托类的方法;
            userImpl.editUser();
            System.out.println("事务结束。。。");
        }

    }

}
