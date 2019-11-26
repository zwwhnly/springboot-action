package com.zwwhnly.springbootaction.javabase.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestSimpleDateFormat {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(simpleDateFormat.parse("2017-12-13 15:17:27"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();
        }
    }
}
