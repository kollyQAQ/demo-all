package com.kolly.learning.thread;

/**
 * Created by kolly on 2017/10/29.
 */
public class Main {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            A aa = new A();
            try {
                aa.notifyTest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            A aa = new A();
            try {
                aa.waitTest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
        Thread thread3 = new Thread(() -> {
            A aa = new A();
            try {
                aa.waitTest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread3.start();
        Thread t = Thread.currentThread();
        System.out.println("ThreadID:" + t.getId() + ", ThreadName:" + t.getName());
    }

    static class A {

        public void waitTest() throws InterruptedException {
            Thread t = Thread.currentThread();
            System.out.println("ThreadID:" + t.getId() + ", ThreadName:" + t.getName() + ",111");
            synchronized (lock) {
                lock.wait();//一直等待
                //lock.wait(3000);//等待3000ms
                Thread.sleep(1000);
            }
            System.out.println("ThreadID:" + t.getId() + ", ThreadName:" + t.getName() + ",222");
        }

        public void notifyTest() throws InterruptedException {
            Thread.sleep(1000);
            Thread t = Thread.currentThread();
            System.out.println("ThreadID:" + t.getId() + ", ThreadName:" + t.getName() + ",333");
            synchronized (lock) {
                //lock.notify();
                lock.notifyAll();
            }
            //Thread.sleep(2000);
            //synchronized (lock) {
            //    lock.notify();
            //}
        }
    }
}

