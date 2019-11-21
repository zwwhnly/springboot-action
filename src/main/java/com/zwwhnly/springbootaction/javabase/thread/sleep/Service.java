package com.zwwhnly.springbootaction.javabase.thread.sleep;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Service {
    public void mSleep() {
        synchronized (this) {
            try {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                System.out.println("Sleep,当前时间：" + simpleDateFormat.format(calendar.getTime()));
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mWait() {
        synchronized (this) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            System.out.println("Wait,当前时间：" + simpleDateFormat.format(calendar.getTime()));
        }
    }
}
