package com.example.demo.java8.chart3;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CompareTest
 * @date 2019/6/17  20:13
 */
public class CompareTest {
    public static void main(String[] args) {
        Integer a = 5;
        Integer b = 7;
        System.out.println(a.compareTo(b));
        //相当于a 比b大多少
        System.out.println(b.compareTo(a));
        System.out.println(a.compareTo(b));
    }
}
