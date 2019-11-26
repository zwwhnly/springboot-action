package com.zwwhnly.springbootaction.javabase.thread.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final ReentrantLockTest reentrantLockTest = new ReentrantLockTest();

        Thread thread1 = new Thread(new MyThread(reentrantLockTest));
        Thread thread2 = new Thread(new MyThread(reentrantLockTest));

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.interrupt();
    }

    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();

        try {
            System.out.println(thread.getName() + "得到了锁");
            long startTime = System.currentTimeMillis();
            for (; ; ) {
                if (System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
                    break;
                //插入数据
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "执行finally");
            lock.unlock();
            System.out.println(thread.getName() + "释放了锁");
        }
    }
}
