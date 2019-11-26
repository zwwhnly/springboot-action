package com.zwwhnly.springbootaction.javabase.thread.synchronize;

import org.omg.SendingContext.RunTime;

public class SyncTest {
    public synchronized void method1() {
        System.out.println("Method 1 start");

        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);

            int zero = 0;
            int result = 3 / zero;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Method 1 end");
    }

    public synchronized void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }
}
