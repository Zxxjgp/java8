package com.example.demo.java8.chap8;

import com.example.demo.demo.FilteringApples;
import com.example.demo.java8.chap4.Dish;
import com.example.demo.java8.chap5.CaloricLevel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Java8Test
 * @date 2019/7/14  16:59
 */
public class Java8Test {



    public static void main(String[] args) {

        List<FilteringApples.Apple> inventory =
                Arrays.asList(new FilteringApples.Apple(80,"green"),
                new FilteringApples.Apple(155, "green"),
                new FilteringApples.Apple(120, "red"));
        doSomething((Task1) () -> System.out.println("qqqq"));
        tt();
        System.out.println(inventory);
        //第一种
        //inventory.sort(Comparator.comparing(FilteringApples.Apple::getWeight));
        inventory.sort((FilteringApples.Apple a2,FilteringApples.Apple a1) -> a1.getWeight().compareTo(a1.getWeight()));
        System.out.println(inventory);


        DefaultTask f = new DefaultTask();
        f.execute();
        f.remove();
    }
    public static void doSomething(Task2 r){ r.execute(); }
    public static void doSomething(Task1 a){ a.execute(); }

    public static void  tt(){
        Map<CaloricLevel, List<Dish>> dish = Dish.menu.stream().collect(groupingBy( x -> {
            if (x.getCalories()<= 400) return CaloricLevel.DIET;
            else if ( x.getCalories() <= 700 ) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }));
        System.out.println(dish);

        Map<CaloricLevel, List<Dish>> dish1 = Dish.menu.stream().collect(groupingBy(Dish::getCaloricLevel));
        System.out.println(dish1);

    }
}
