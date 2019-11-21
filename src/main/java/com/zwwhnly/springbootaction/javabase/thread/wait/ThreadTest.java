package com.zwwhnly.springbootaction.javabase.thread.wait;

public class ThreadTest {
    public static void main(String[] args) {
        Service service = new Service();

        try {
            service.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*SleepThread sleepThreadRunnable = new SleepThread(service);
        WaitThread waitThreadRunnable = new WaitThread(service);

        System.out.println(sleepThreadRunnable.getService() == waitThreadRunnable.getService());

        Thread sleepThread = new Thread(sleepThreadRunnable);
        Thread waitThread = new Thread(waitThreadRunnable);

        waitThread.start();
        sleepThread.start();*/
    }
}
