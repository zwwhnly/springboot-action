package com.zwwhnly.springbootaction.date;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("today: " + today);

        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.println("year: " + year);
        System.out.println("month: " + month);
        System.out.println("day: " + day);

        System.out.println();

        LocalDate specifiedDate = LocalDate.of(2020, Month.JUNE, 1);
        System.out.println("specifiedDate: " + specifiedDate);

        /*比较日期是否相等*/
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2020, Month.JUNE, 10);
        if (localDate1.equals(localDate2)) {
            System.out.println("localDate1 equals localDate2");
        }

        System.out.println("Today:" + today);
        System.out.println("Today is:" + today.getDayOfWeek());
        System.out.println("今天是本周的第" + today.getDayOfWeek().getValue() + "天");
        System.out.println("今天是本月的第" + today.getDayOfMonth() + "天");
        System.out.println("今天是本年的第" + today.getDayOfYear() + "天");

        System.out.println(today.getYear() + " is leap year:" + today.isLeapYear());

        Date date = new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDate localDate = localDateTimeOfInstant.toLocalDate();
        System.out.println(date);
        System.out.println(localDate);

        LocalDateTime localDateTime = localDate.atStartOfDay();
        Instant toInstant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date dateFromLocalDate = Date.from(toInstant);
        System.out.println(dateFromLocalDate);
    }
}
