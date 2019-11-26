package com.zwwhnly.springbootaction.javabase.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest2 {
    private static volatile Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " A task over");
                semaphore.release();
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " A task over");
                semaphore.release();
            }
        });

        semaphore.acquire(2);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " B task over");
                semaphore.release();
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " B task over");
                semaphore.release();
            }
        });

        semaphore.acquire(2);

        System.out.println("task is over");

        executorService.shutdown();
    }
}
