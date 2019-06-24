package com.example.demo.java8.chap5;

import com.example.demo.java8.chap4.Dish;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TestTrader
 * @date 2019/6/18  21:54
 */
public class TestTrader
{
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //找出了从2011年代的所有交易信息的按照交易之从大到小的排序
        List<Transaction> collect = transactions.stream().filter(x -> x.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());


        //找出交易员在不同的城市工作过
        List<String> collect1 = transactions.stream().map(x -> x.getTrader().getCity())
                .distinct().collect(Collectors.toList());

        //找出所有来自于剑桥的交易并且按照名字的首字母进行排序
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        //找出了所有姓名的字母机芯排序
        String reduce = transactions.stream()
                .map(x -> x.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a, b) -> a + b);
        String collect2 = transactions.stream()
                .map(x -> x.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());

        System.out.println(reduce + "*****" + collect2);
        System.out.println(reduce.equals(collect2));

        //找出有没有在米兰工作的
        boolean milan = transactions.stream().anyMatch(x -> x.getTrader().getCity().equals("Milan"));
        System.out.println(milan);

        transactions.stream().filter( x ->  "Cambridge".equals(x.getTrader().getCity()))
                 .map( x -> x.getValue())
                .forEach(System.out::println);
        Optional<Transaction> min = transactions.stream().min(comparing(Transaction::getValue));
        System.out.println("))))"+min.get());
        Optional<Transaction> max = transactions.stream().max(comparing(Transaction::getValue));
        System.out.println("))))"+max.get());

        //计算所有的交易额
        Integer reduce1 = transactions.stream().map(x -> x.getValue()).reduce(0, Integer::sum);
        System.out.println(reduce1);

        int calories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        System.out.println(calories);

        IntStream intStream = Dish.menu.stream().mapToInt(Dish::getCalories);
      //  System.out.println(intStream.count());
        Stream<Integer> boxed = intStream.boxed();
        System.out.println("*(****"+boxed.count());


        OptionalInt ee = transactions.stream().mapToInt(Transaction::getValue).max();
        System.out.println(ee.getAsInt());
        //如果没有最大值就显示的给他一个最大值
        System.out.println(ee.orElse(1));

        long count = IntStream.range(1, 100).filter(x -> x % 2 == 0).count();
        long count1 = IntStream.rangeClosed(1, 100).filter(x -> x % 2 == 0).count();
        System.out.println(count);
        System.out.println(count1);

        int x= 9;
        System.out.println(Math.sqrt(9) %1  );



        List<int[]> collect3 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b ->
                                        new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                ).collect(toList());
        System.out.println(collect3);

        int[] h = {12,33,43,54,54};
        int sum = Arrays.stream(h).sum();
        System.out.println(sum);
        long union = 0;
        long count2 = 0;
        try {
            Stream<String> lines = Files.lines(Paths.get("C:\\data.txt"), Charset.defaultCharset());
            count2 = lines.flatMap(v -> Arrays.stream(v.split(""))).distinct().count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count2);
    }


}
