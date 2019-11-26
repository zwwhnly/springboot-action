package com.zwwhnly.springbootaction.javabase.thread.synchronize;

public class TxtThread implements Runnable {
    int num = 10;
    String str = new String();

    public void run() {
        synchronized (str) {
            while (num > 0) {

                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.getMessage();
                }
                System.out.println(Thread.currentThread().getName()
                        + "this is " + num--);
            }
        }
    }
}
