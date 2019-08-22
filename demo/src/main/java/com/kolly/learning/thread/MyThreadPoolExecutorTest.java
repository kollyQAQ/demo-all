package com.kolly.learning.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019/4/10
 */
public class MyThreadPoolExecutorTest {

    public static void main(String[] args) {
        MyThreadPoolExecutor threadPoolExecutor = new MyThreadPoolExecutor(3, 10,
                60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(5));

        for (int i = 0; i < 30; i++) {
            threadPoolExecutor.execute(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("task " + threadName + " is coming");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static class MyThreadPoolExecutor extends ThreadPoolExecutor {

        public MyThreadPoolExecutor(int corePoolSize,
                                    int maximumPoolSize,
                                    long keepAliveTime,
                                    TimeUnit unit,
                                    BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            System.out.println("=======before execute task=======");
            System.out.println("getTaskCount:" + getTaskCount());
            System.out.println("getCompletedTaskCount:" + getCompletedTaskCount());
            System.out.println("getLargestPoolSize:" + getLargestPoolSize());
            System.out.println("getPoolSize:" + getPoolSize());
            System.out.println("getActiveCount:" + getActiveCount());
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            System.out.println("=======after execute task=======");
        }
    }
}
