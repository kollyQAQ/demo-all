package com.kolly.learning.base;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019-08-16
 * <p>
 * 利用软引用 SoftReference 实现的内存缓存
 */
public class SoftReferenceCache {
    private HashMap<Object, ObjectRef> softCache;//用于cache内容的存储
    private ReferenceQueue<Object> queue;//reference的队列

    /**
     * 创建一个私有弱引用的数据类,再利用队列获得这个弱引用,利用该弱引用清除缓存立仍然存在的键值对
     * 这里用了一个information类,里面的name作为一个唯一键(唯一键可以利用Hash值,类似mybatis)
     */
    private class ObjectRef extends SoftReference<Object> {
        //主要用于清除HashMap中的键值对
        Object key;

        public ObjectRef(Object key, Object value, ReferenceQueue<Object> queue) {
            super(value, queue);
            this.key = key;
        }
    }

    /**
     * 构造方法
     */
    public SoftReferenceCache() {
        softCache = new HashMap<>();
        queue = new ReferenceQueue<>();
    }

    /**
     * 插入缓存数据
     */
    public void set(Object key, Object value) {
        //先清除已经被GC的软引用
        cleanCache();
        ObjectRef ref = new ObjectRef(key, value, queue);
        softCache.put(key, ref);
    }

    /**
     * 获取缓存数据
     */
    public Object get(Object value) {
        ObjectRef ref = softCache.get(value);
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    /**
     * 清除队列中无用引用的同时清除SoftCache中的无效关系(这里可以用WeakMap)
     */
    private void cleanCache() {
        ObjectRef ref = null;
        while ((ref = (ObjectRef) queue.poll()) != null) {
            softCache.remove(ref.key);
        }
    }

    /**
     * 清空缓存
     */
    public void clear() {
        cleanCache();
        softCache.clear();
    }
}
