package com.zwwhnly.springbootaction.javabase.thread.countdown;

import java.util.concurrent.CountDownLatch;

public class JoinCountDownLatch {
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("child threadOne over!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("child threadTwo over!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        System.out.println("wait all child thread over!");

        countDownLatch.await();

        System.out.println("all child thread over!");
    }
}
