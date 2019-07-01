package com.example.demo.java8.chap6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TestConntinue
 * @date 2019/6/28  13:19
 */
public class TestConntinue {
    public static void main(String[] args) {

        long currentTime = Calendar.getInstance().getTime().getTime();
/*        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long parse = 0;
        try {
            parse = simpleDateFormat.parse("2019-06-28 14:16:31").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        System.out.println(currentTime);
        System.out.println(Calendar.getInstance().getTimeInMillis());

        String str = "济南市";
        System.out.println(str.substring(0,str.length()-1));



    }
}
