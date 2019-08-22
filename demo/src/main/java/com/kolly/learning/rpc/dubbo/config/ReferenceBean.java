package com.kolly.learning.rpc.dubbo.config;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author kolly
 * @Date 2018/4/12.li
 * Modified Logs:
 * Created by kolly.li on 2018/4/12.
 */
public class ReferenceBean<T> extends com.kolly.learning.rpc.dubbo.config.ReferenceConfig<T> implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return get();
    }

    @Override
    public Class<?> getObjectType() {
        return getInterfaceClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}