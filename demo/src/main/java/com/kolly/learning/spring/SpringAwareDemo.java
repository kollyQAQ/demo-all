package com.kolly.learning.spring;

import com.kolly.learning.spring.po.FootballPlayer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019-08-23
 * <p>
 * Aware，是感应和感知的意思。当 bean 实现了对应的 Aware 接口时，BeanFactory会在生产 bean 时根据它所实现的 Aware 接口，
 * 给 bean 注入对应的属性，从而让 bean 获取外界的信息
 * <p>
 * ApplicationContextAware：实现类的实例将会获取 ApplicationContext 的引用，因此可以编程式的使用 ApplicationContext 手动创建 bean
 * BeanFactoryAware： 实现类的实例将会获取 BeanFactoryAware 的引用，
 * BeanNameAware：在bean 内部，它并不知道容器给自己取了个什么 id，如果想要获取自己在容器中的 id，可以实现 BeanNameAware 接口获取
 */
@Component
public class SpringAwareDemo implements BeanNameAware, ApplicationContextAware, BeanFactoryAware {

    private String beanname;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("通过 BeanFactoryAware 接口实现，获得了容器对象："
                + this.beanFactory.toString().substring(0, 35) + "......");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("通过 ApplicationContextAware 接口实现，获得了容器对象："
                + this.applicationContext.toString().substring(0, 35) + "......");
        FootballPlayer player = applicationContext.getBean("footballPlayer", FootballPlayer.class);
        player.setName("maladona");
        player.pass();
        player.shoot();
    }

    @Override
    public void setBeanName(String name) {
        this.beanname = name;
        System.out.println("通过 BeanNameAware 接口的实现，我知道我的名字是：" + this.beanname);
    }
}
