package com.kolly.learning.learning;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019-08-16
 * <p>
 * 使用 LinkedHashMap 实现的一个 LRU 缓存
 * LRU：Least Recently Used的缩写，即最近最少使用
 */
public class LRUCacheDemo {

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>();
        cache.put(1, "a"); // [1]
        cache.put(2, "b"); // [1] -> [1,2]
        cache.put(3, "c"); // [1,2] -> [1,2,3]
        cache.get(1); // [1,2,3] -> [2,3,1]
        cache.put(4, "d"); // [2,3,1] -> [2,3,1,4] -> [3,1,4]
        cache.put(3, "f"); // [3,1,4] -> [1,4,3]
        System.out.println(cache.keySet()); // output: [1,4,3]
    }

    static class LRUCache<K, V> extends LinkedHashMap<K, V> {

        /**
         * 设定最大缓存空间 MAX_ENTRIES 为 3；
         */
        private static final int MAX_ENTRIES = 3;

        /**
         * 使用 LinkedHashMap 的构造函数将 accessOrder 设置为 true，开启 LRU 顺序；
         */
        LRUCache() {
            super(MAX_ENTRIES, 0.75f, true);
        }

        /**
         * 覆盖 removeEldestEntry() 方法实现，在节点多于 MAX_ENTRIES 就会将最近最久未使用的数据移除。
         */
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_ENTRIES;
        }
    }
}
