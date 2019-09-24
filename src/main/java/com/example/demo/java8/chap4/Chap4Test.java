package com.example.demo.java8.chap4;


import java.util.Arrays;
import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Chap4Test
 * @date 2019/6/17  23:08
 */
public class Chap4Test {
    public static void main(String[] args) {


        List<Integer> words = Arrays.asList(4, 6,30,10,20);

        int i = words.stream().reduce(100, (x, y) -> x + y);
        System.out.println(i);


        words.stream().forEach( x -> System.out.println(x.getClass().getName()+"====="));
        Dish g = new  Dish(){

            public void run(){
                System.out.println(88);
            }
        };
        Runnable r2 = () -> System.out.println("Hello");


        String str = "";

        if ( 0 > 0 ) {
            System.out.println(444);
        }

    }
}
