package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : CM
 * @date : 2019/3/4
 */
public class DateUtils {
    /** 时间格式(yyyy-MM-dd) */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /** 时间格式(yyyy-MM-dd HH:mm:ss) */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    SimpleDateFormat START_TIME = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    SimpleDateFormat END_TIME = new SimpleDateFormat("yyyy-MM-dd 23:59:59");


    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     * @param date  日期
     * @return 返回yyyy-MM-dd格式日期
     */
    public static String format(Date date) {
        return format(date, DATE_TIME_PATTERN);
    }

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     * @param date  日期
     * @param pattern  格式，如：DateUtils.DATE_TIME_PATTERN
     * @return 返回yyyy-MM-dd格式日期
     */
    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }


    /**
     * 向后加一天
     */
/*    public static Date addDays(Date date , int days ){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        task.setEndTime(sdf.parse(sdf.format(cal.getTime())));
    }*/


    /**
     * 时间生成器
     */
    public static Date productDate(Date date , int hour , int minute , int second , int day ){
        Calendar calendar = Calendar. getInstance();
        calendar.setTime( date);
        calendar.set(Calendar. HOUR_OF_DAY, hour);
        calendar.set(Calendar. MINUTE, minute);
        calendar.set(Calendar. SECOND, second);
        calendar.set(Calendar. MILLISECOND, 0);
        calendar.add(Calendar. DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        Date date = new Date();
        String format = DateUtils.format(DateUtils.productDate(date, 00, 00, 1, 0));
        System.out.println(format);

        System.out.println(DateUtils.format(DateUtils.productDate(date,23,59,59,2-1)));



    }
}
