package com.kolly.learning.spring.po;

import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019-08-23
 */
@Data
public class FootballPlayer implements BeanNameAware, InitializingBean, DisposableBean {

    private String name;

    public void pass() {
        System.out.println(this.name + " 边路传中");
    }

    public void shoot() {
        System.out.println(this.name + " 射门啦");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("通过 BeanNameAware 接口的实现，我知道我的名字是：" + name);
    }

    @PostConstruct //初始化方法的注解方式  等同与init-method = init
    public void init() {
        System.out.println("使用注解 @PostConstruct，调用初始化方法 init ....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("FootballPlayer 实现了 InitializingBean 接口，执行了 afterPropertiesSet 方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("FootballPlayer 实现了 DisposableBean 接口，执行了 destroy 方法");
    }

    @PreDestroy    //销毁方法的注解方式  等同于destory-method = destory
    public void destory() {
        System.out.println("使用注解 @PreDestroy，调用销毁化方法 destory ....");
    }
}
