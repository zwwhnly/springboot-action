package com.zwwhnly.springbootaction.date;

import java.time.*;
import java.util.Date;

public class LocalTimeDemo {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime:" + localTime);

        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();
        int nono = localTime.getNano();

        System.out.println("hour: " + hour);
        System.out.println("minute: " + minute);
        System.out.println("second: " + second);
        System.out.println("nano:" + nono);

        Date date = new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalTime toLocalTime = localDateTimeOfInstant.toLocalTime();
        System.out.println(date);
        System.out.println(toLocalTime);

        LocalDate localDate = LocalDate.now();
        //LocalTime localTime = LocalTime.now();

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Instant instantFromLocalTime = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date dateFromLocalTime = Date.from(instantFromLocalTime);

        System.out.println(dateFromLocalTime);
    }
}
