package com.kolly.learning.springboot.cache;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019/7/1
 */
@Component
@EnableCaching
public class UserDao {

    private HashMap<Long, User> userMap = new HashMap<>();

    @PostConstruct
    public void init() {
        //模拟数据库
        userMap.put(1L, new User(1L, "micro1"));
        userMap.put(2L, new User(2L, "micro2"));
    }

    @Cacheable("refreshTest#5#3")  // 注解key属性可以执行缓存对象user(可以理解为一个map)的key
    public User getRefreshTestUser(Long userId) {
        System.out.println("查询数据库:userId ->" + userId);
        User user = new User();
        user.setId(userId);
        user.setName(RandomStringUtils.random(10, true, true));
        return user;
    }

    @Cacheable("user")  // 注解key属性可以执行缓存对象user(可以理解为一个map)的key
    public User getUser(Long userId) {
        System.out.println("查询数据库:userId ->" + userId);
        return userMap.get(userId);
    }

    @Cacheable(value = "nameCache", key = "#name")
    public User getUserByName(Long userId, String name) {
        System.out.println("查询数据库:userId ->" + userId);
        return userMap.get(userId);
    }

    @Cacheable(value = "idNameCache")
    public User getUserByNameAndId(Long userId, String name) {
        System.out.println("查询数据库:userId + name ->" + userId + ":" + name);
        return userMap.get(userId);
    }

    @Cacheable("nameCache")
    public User getUserByName(String name) {
        System.out.println("查询数据库:userName : " + name);
        for (Long k : userMap.keySet()) {
            if (userMap.get(k).equals(name)) {
                return userMap.get(k);
            }
        }
        return null;
    }

    @CachePut("user") // 与Cacheable区别就是Cacheable先看缓存如果有，直接缓存换回，CachePut则是每次都会调用并且把返回值放到缓存
    public User getUser2(Long userId) {
        System.out.println("查询数据库:userId : " + userId);
        return userMap.get(userId);
    }

    @CacheEvict("user")
    public void removeFromCache(Long userId) {

    }
}
