package com.example.demo.java8.chap11;

import java.time.*;
import java.time.temporal.ChronoField;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName DateTest
 * @date 2019/8/4  23:17
 */
public class DateTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getMonth().getValue());
        LocalDate ll = LocalDate.of(2019,12,31);
        System.out.println(ll.getYear());
        System.out.println(ll.getDayOfYear());
        System.out.println(ll.getDayOfMonth());
        System.out.println("==============testDate start===========================");
        testDate();
        System.out.println("===============testDate  end==========================");
    }

    public static void testDate(){
        LocalDate l = LocalDate.now();
        int month = l.get(ChronoField.YEAR);
        System.out.println(month);
        int year  = l.get(ChronoField.DAY_OF_YEAR);
        System.out.println(year);


        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getHour());
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getHour());

        Period tenDays = Period.between(LocalDate.of(2014, 5, 12),
                LocalDate.of(2013, 5, 18));

        System.out.println(tenDays.getDays());

        Instant instant = Instant.ofEpochSecond(3);
        System.out.println(instant.getNano());
        Instant.ofEpochSecond(3, 0);
        Instant.ofEpochSecond(2, 1_000_000_000);
        Instant.ofEpochSecond(4, -1_000_000_000);

    }
}
