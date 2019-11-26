package com.zwwhnly.springbootaction.javabase.thread.synchronize;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SynchronizedTest {

    public static void main(String[] args) {
        /*final SyncTest syncTest = new SyncTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                syncTest.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                syncTest.method2();
            }
        }).start();*/

        TxtThread tt = new TxtThread();
        new Thread(tt).start();
        new Thread(tt).start();
        new Thread(tt).start();
        new Thread(tt).start();
    }
}
