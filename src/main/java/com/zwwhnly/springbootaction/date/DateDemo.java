package com.zwwhnly.springbootaction.date;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("date: " + date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("date: " + simpleDateFormat.format(date));

        int hour = date.getHours();
        int minute = date.getMinutes();
        int second = date.getSeconds();
        System.out.println("hour: " + hour);
        System.out.println("minute: " + minute);
        System.out.println("second: " + second);

        Instant instant = Instant.now();
        System.out.println(instant);

        Date dateFromInstant = Date.from(instant);
        System.out.println(dateFromInstant);
    }
}
