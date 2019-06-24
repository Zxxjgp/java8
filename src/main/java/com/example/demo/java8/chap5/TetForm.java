package com.example.demo.java8.chap5;

import com.example.demo.java8.chap4.Dish;

import javax.xml.transform.Source;
import java.time.Year;
import java.util.OptionalInt;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TetForm
 * @date 2019/6/21  16:01
 */
public class TetForm {
    public static void main(String[] args) {
        for ( int i = 0 ; i < 2 ; i++ ) {
            System.out.println("11111111111111111111111111111");
        }
        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu);
        Integer collect = Dish.menu.stream().collect(reducing(0, Dish::getCalories, (x, y) -> x + y));
        System.out.println(collect);
        long max = Dish.menu.stream().collect((reducing(0,
                Dish::getCalories,
                Integer::sum)));
        System.out.println(max);

        int asInt = Dish.menu.stream().mapToInt(Dish::getCalories).reduce(Integer::sum).getAsInt();
        System.out.println(asInt);
        int sum = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum);
    }
}
