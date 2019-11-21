package com.zwwhnly.springbootaction.javabase.thread.wait;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Service {
    public void mSleep() {
        synchronized (this) {
            try {
                this.notify();
                Thread.sleep(3 * 1000);

                

                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //System.out.println("Sleep,唤醒等待,当前时间：" + simpleDateFormat.format(calendar.getTime()));
                System.out.println("Sleep,唤醒等待,当前时间：" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mWait() {
        synchronized (this) {
            try {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //System.out.println("Wait,开始等待,当前时间：" + simpleDateFormat.format(calendar.getTime()));
                System.out.println("Wait,开始等待,当前时间：" + System.currentTimeMillis());

                this.wait();

                //System.out.println("Wait,我被唤醒了,当前时间：" + simpleDateFormat.format(calendar.getTime()));
                System.out.println("Wait,我被唤醒了,当前时间：" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
