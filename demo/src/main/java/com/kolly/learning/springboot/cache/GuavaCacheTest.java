package com.kolly.learning.springboot.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019/7/1
 */
public class GuavaCacheTest {

    private static LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            // 设置缓存在写入 10s 后，通过CacheLoader的load方法进行刷新
            .refreshAfterWrite(10, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) {
                    if (s.equals("key1")) {
                        return RandomStringUtils.random(20, true, true);
                    }
                    return RandomStringUtils.random(10, true, true);
                }
            });

    public static void main(String[] args) throws Exception {
        cache.put("key1", "init data");
        for (int i = 0; i < 10; i++) {
            System.out.println("key1 ===> " + cache.get("key1"));
            System.out.println("key1 ===> " + cache.get("key2"));
            Thread.sleep(3000L);
        }
    }
}
