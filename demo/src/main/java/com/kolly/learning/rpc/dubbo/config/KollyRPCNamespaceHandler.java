package com.kolly.learning.rpc.dubbo.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Author kolly
 * @Date 2018/4/12.li
 * Modified Logs:
 * Created by kolly.li on 2018/4/12.
 */
public class KollyRPCNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("reference", new KollyRPCBeanDefinitionParser());
    }
}
