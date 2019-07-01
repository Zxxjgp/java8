package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
         public static void main(String[] args) {
            /**
            * 生成当前时间后一天时间零点
            * 例如:当前时间为2016/7/18 15:44:30
            *           生成时间为2016/7/19 00:00:00
            */
           Calendar calendar = Calendar. getInstance();
           calendar.setTime( new Date());
           calendar.set(Calendar. HOUR_OF_DAY, 23);
           calendar.set(Calendar. MINUTE, 59);
           calendar.set(Calendar. SECOND, 59);
           calendar.set(Calendar. MILLISECOND, 0);
           calendar.add(Calendar. DAY_OF_MONTH, 0);
           Date date = calendar.getTime();
           System.out.println(date);
            /**
            * 将date类型的时间转换成String类型
            */
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
           String str = sdf.format(date);
           System. out.println(str);
     }
}