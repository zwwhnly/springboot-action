package com.zwwhnly.springbootaction.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        // 月份的下标是从0开始的，即0~11分别代表1~12月，因此需要+1
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("year: " + year);
        System.out.println("month: " + month);
        System.out.println("day: " + day);

        // 12小时制
        int hourOf12 = calendar.get(Calendar.HOUR);
        // 24小时制
        int hourOf24 = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int milliSecond = calendar.get(Calendar.MILLISECOND);

        System.out.println("hourOf12: " + hourOf12);
        System.out.println("hourOf24: " + hourOf24);
        System.out.println("minute: " + minute);
        System.out.println("second: " + second);
        System.out.println("milliSecond: " + milliSecond);

        System.out.println("现在是：" + year + "年" + month + "月" + day + "日" + hourOf24 + "时" + minute + "分" + second + "秒");

        calendar.set(2019, Calendar.FEBRUARY, 21, 23, 59, 59);
        System.out.println(calendar.getTime());

        calendar.add(Calendar.SECOND, 1);
        System.out.println(calendar.getTime());

        System.out.println(getFirstDayOfMonth(2019, 2));
        System.out.println(getLastDayOfMonth(2019, 2));

        System.out.println(getFirstDayOfMonth(2019, 3));
        System.out.println(getLastDayOfMonth(2019, 3));
    }

    public static String getLastDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DATE));

        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }

    public static String getFirstDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getMinimum(Calendar.DATE));

        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }
}
