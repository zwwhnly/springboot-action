package com.zwwhnly.springbootaction.javabase.thread.lock;

public class MyThread implements Runnable {
    private ReentrantLockTest reentrantLockTest = null;

    public MyThread(ReentrantLockTest reentrantLockTest) {
        this.reentrantLockTest = reentrantLockTest;
    }

    @Override
    public void run() {
        try {
            reentrantLockTest.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断");
        }
    }
}
