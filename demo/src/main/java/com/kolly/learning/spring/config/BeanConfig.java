package com.kolly.learning.spring.config;

import com.kolly.learning.spring.po.FootballPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019-08-23
 */
@Configuration
public class BeanConfig {

    @Bean
    public FootballPlayer footballPlayer() { // bean 的名字不指定的话默认是方法名
        FootballPlayer footballPlayer = new FootballPlayer();
        footballPlayer.setName("messi");
        return footballPlayer;
    }
}
