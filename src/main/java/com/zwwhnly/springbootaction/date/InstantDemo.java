package com.zwwhnly.springbootaction.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class InstantDemo {
    public static void main(String[] args) {
        /*
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant localDateTime2Instant= localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(System.currentTimeMillis());
        System.out.println(localDateTime2Instant.toEpochMilli());*/

        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(instant.atZone(ZoneId.systemDefault()));

        // 当前时间戳:单位为秒
        long epochSecond = instant.getEpochSecond();
        System.out.println(epochSecond);
        // 当前时间戳:单位为毫秒
        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli);


        System.out.println(Instant.ofEpochSecond(epochSecond));
        System.out.println(Instant.ofEpochSecond(epochSecond, instant.getNano()));

        System.out.println(Instant.ofEpochMilli(epochMilli));

        String text = "2020-06-10T08:46:55.967Z";
        Instant parseInstant = Instant.parse(text);
        System.out.println("秒时间戳:" + parseInstant.getEpochSecond());
        System.out.println("豪秒时间戳:" + parseInstant.toEpochMilli());
        System.out.println("纳秒:" + parseInstant.getNano());

        Date date = new Date();
        Instant dateToInstant = date.toInstant();
        System.out.println(date);
        System.out.println(dateToInstant);
    }
}
