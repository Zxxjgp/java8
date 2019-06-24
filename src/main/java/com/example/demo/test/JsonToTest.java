package com.example.demo.test;


import com.example.demo.enums.LoanStatusCode;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName JsonToTest
 * @date 2019/4/10  16:45
 */
public class JsonToTest {
    public static void main(String[] args) {
        Date a = new Date();
        String str = "2019-06-06 22:15:12";
        Date date = strToDateLong(str);
        System.out.println(date);
        System.out.println(date.after(a));

        String key = "";
        for (LoanStatusCode loanStatusCode : LoanStatusCode.values() ) {
            if ( "1".equals(loanStatusCode.getCode())) {
                key = loanStatusCode.getMsg();
            }
        }

        System.out.println(key);
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
}
