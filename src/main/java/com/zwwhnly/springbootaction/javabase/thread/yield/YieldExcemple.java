package com.zwwhnly.springbootaction.javabase.thread.yield;

public class YieldExcemple {
    public static void main(String[] args) {
        Thread threadA = new Thread(new ThreadA());
        Thread threadB = new Thread(new ThreadB());

        threadA.setPriority(Thread.MIN_PRIORITY);
        threadB.setPriority(Thread.MAX_PRIORITY);

        threadA.start();
        threadB.start();
    }
}

class ThreadA implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadA--" + i);
            Thread.yield();
        }
    }
}

class ThreadB implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadB--" + i);
            Thread.yield();
        }
    }
}
