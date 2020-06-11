package com.zwwhnly.springbootaction.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime: " + localDateTime);

        System.out.println("year: " + localDateTime.getYear());
        System.out.println("month: " + localDateTime.getMonthValue());
        System.out.println("day: " + localDateTime.getDayOfMonth());
        System.out.println("hour: " + localDateTime.getHour());
        System.out.println("minute: " + localDateTime.getMinute());
        System.out.println("second: " + localDateTime.getSecond());

        System.out.println("DayOfWeek: " + localDateTime.getDayOfWeek().getValue());
        System.out.println("DayOfYear: " + localDateTime.getDayOfYear());

        LocalDateTime tomorrow = localDateTime.plusDays(1);
        System.out.println("tomorrow: " + tomorrow);

        LocalDateTime nextHour = localDateTime.plusHours(1);
        System.out.println("nextHour: " + nextHour);

        LocalDateTime yesterday = localDateTime.minusDays(1);
        System.out.println("yesterday: " + yesterday);

        LocalDateTime lastHour = localDateTime.minusHours(1);
        System.out.println("lastHour: " + lastHour);

        Date date = new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(date);
        System.out.println(localDateTimeOfInstant);

        Instant toInstant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date dateFromInstant = Date.from(toInstant);
        System.out.println(localDateTime);
        System.out.println(dateFromInstant);
    }
}
