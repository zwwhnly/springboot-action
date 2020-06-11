package com.zwwhnly.springbootaction.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String[] args) {
        Date currentTime = new Date();
        System.out.println(currentTime);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy/MM/dd");

        System.out.println(simpleDateFormat1.format(currentTime));
        System.out.println(simpleDateFormat2.format(currentTime));
        System.out.println(simpleDateFormat3.format(currentTime));

        simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String strDate1 = "2019-02-18 13:58";
        String strDate2 = "2019-02-18";

        try {
            Date date1 = simpleDateFormat1.parse(strDate1);
            System.out.println(date1);
            Date date2 = simpleDateFormat1.parse(strDate2);
            System.out.println(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
