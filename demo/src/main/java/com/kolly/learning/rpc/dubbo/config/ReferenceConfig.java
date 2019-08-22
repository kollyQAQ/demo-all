package com.kolly.learning.rpc.dubbo.config;


import com.kolly.learning.rpc.dubbo.proxy.MenuServiceImpl;
import com.kolly.learning.rpc.dubbo.proxy.ProxyFactory;

/**
 * @Author kolly
 * @Date 2018/4/12.li
 * Modified Logs:
 * Created by kolly.li on 2018/4/12.
 */
public class ReferenceConfig<T> {

    private Class<?> interfaceClass;

    // 接口代理类引用
    private transient volatile T ref;

    public synchronized T get() {
        if (ref == null) {
            init();
        }
        return ref;
    }

    private void init() {
        //region 模拟根据 interfaceClass 得到其实现类
        Object object = null;
        if (interfaceClass != null) {
            object = new MenuServiceImpl();
        }
        //endregion
        ref = new ProxyFactory(object).getProxyObject();
    }

    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }
}