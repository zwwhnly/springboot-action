package com.zwwhnly.springbootaction.javabase.thread.sleep;

public class ThreadTest {
    public static void main(String[] args) {
        Service service = new Service();

        SleepThread sleepThreadRunnable = new SleepThread(service);
        WaitThread waitThreadRunnable = new WaitThread(service);

        System.out.println(sleepThreadRunnable.getService() == waitThreadRunnable.getService());

        Thread sleepThread = new Thread(sleepThreadRunnable);
        Thread waitThread = new Thread(waitThreadRunnable);

        sleepThread.start();
        waitThread.start();
    }
}
