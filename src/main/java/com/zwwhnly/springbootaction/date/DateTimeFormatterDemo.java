package com.zwwhnly.springbootaction.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();

        System.out.println("ISO_DATE: " + localDate.format(DateTimeFormatter.ISO_DATE));
        System.out.println("BASIC_ISO_DATE: " + localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println("ISO_WEEK_DATE: " + localDate.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println("ISO_ORDINAL_DATE: " + localDate.format(DateTimeFormatter.ISO_ORDINAL_DATE));
        System.out.println("yyyy/MM/dd: " + localDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println("ISO_TIME: " + localTime.format(DateTimeFormatter.ISO_TIME));
        System.out.println("HH:mm:ss: " + localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println("ISO_DATE_TIME: " + localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("ISO_DATE: " + localDateTime.format(DateTimeFormatter.ISO_DATE));
    }
}
