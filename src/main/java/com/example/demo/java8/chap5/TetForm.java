package com.example.demo.java8.chap5;

import com.example.demo.java8.chap4.Dish;


import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

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
        //字符串的拼接工作
        String collect2 = Dish.menu.stream().map(Dish::getName).collect(joining(""));
        System.out.println(collect2);
        Optional<String> collect1 = Dish.menu.stream().map(Dish::getName).collect(reducing((a, b) -> a + b));
        System.out.println(collect1.get());

        String collect3 = Dish.menu.stream().collect(reducing("", Dish::getName, (x, y) -> x + y));
        System.out.println(collect3);



        //分组交易
        Map<String, List<Dish>> collect4 = Dish.menu.stream().collect(groupingBy(Dish::getName));
        System.out.println(collect4);


        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Dish.menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                }));


        System.out.println(dishesByCaloricLevel);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> ewew =
                Dish.menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                         else return CaloricLevel.FAT;
                                } )
                        )
                );

        System.out.println(ewew);

        Map<Dish.Type, Long> collect5 = Dish.menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(collect5);


        Map<Dish.Type, Optional<Dish>> collect6 = Dish.menu.stream().collect(
                groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));

        System.out.println(collect6.get(Dish.Type.OTHER).get().getCalories());

        //结果集的转换
        Map<Dish.Type, Dish> collect7 = Dish.menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(
                maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(collect7);

        for (int i = 0 ; i < 2 ; i++) {
            System.out.println("**************************");
        }

        //分区函数啊
        Map<Boolean, List<Dish>> collect8 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian));
        //利用过滤器也可以达到同样的效果
        List<Dish> collect9 = Dish.menu.stream().filter(Dish::isVegetarian).collect(toList());
        System.out.println(collect9);
        System.out.println(collect8.get(true));
        System.out.println(collect8.get(false));

        Map<Boolean, Map<Boolean, List<Dish>>> collect10 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, partitioningBy(
                d -> d.getCalories() > 500)));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(collect10.get(true));
        System.out.println(collect10.get(false));
        Map<Boolean, Dish> collect11 = Dish.menu.stream().collect(
                partitioningBy(Dish::isVegetarian,
                        collectingAndThen(
                                maxBy(comparingInt(Dish::getCalories)), Optional::get)));

        System.out.println("****************************************");
        System.out.println(collect11.get(true));
        System.out.println(collect11.get(false));


        Trader t = new Trader();
        t.setCity("wwwwwwwwww");
        t.setName("kk");
        t.setPoints(5);
        t.setQu(3);
        t.setCity(t.getCity().replaceAll(t.getCity(),"88888888"));
        System.out.println(t.getCity());


        t.setPoints(t.getQu()*t.getPoints());
        System.out.println(t.getPoints());
    }
}
