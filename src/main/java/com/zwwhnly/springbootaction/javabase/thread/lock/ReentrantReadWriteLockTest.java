package com.zwwhnly.springbootaction.javabase.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();

        new Thread() {
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();

        new Thread() {
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();
    }

    public void get(Thread thread) {
        readWriteLock.readLock().lock();

        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
