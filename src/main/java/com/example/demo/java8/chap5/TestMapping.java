package com.example.demo.java8.chap5;

import com.example.demo.java8.chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static com.example.demo.java8.chap4.Dish.menu;
import static java.util.stream.Collectors.toList;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TestMapping
 * @date 2019/6/18  14:28
 */
public class TestMapping {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");
        //map
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);

        List<String> collect = words.stream()
                .map(x -> x.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(collect);

        List<Integer> numbers = Arrays.asList(3,4,5,1,2);
        List<Integer> collect1 = numbers.stream().sorted((x, y) -> Integer.compare(x, y)).collect(toList());
        System.out.println(numbers);
        System.out.println(collect1);
        List<Integer> collect2 = collect1.stream().map(x -> x * x).collect(toList());
        System.out.println(collect2);

        List<Integer> numbers1 = Arrays.asList(2, 2, 9);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i ->
                                numbers2.stream()
                                        .filter(j -> (i + j) % 3 == 0)
                                        .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        System.out.println(pairs);

        List<int[]> collect3 = numbers1.stream()
                .flatMap(x -> numbers2.stream()
                        .filter(j -> (x + j) % 3 == 0).map(j -> new int[]{x, j}))
                .collect(toList());
        System.out.println(collect3.size());
        System.out.println(collect3.get(1).length);

        List<Boolean> collect4 = menu.stream().map(Dish::isVegetarian).collect(toList());


        List<String> strs = Arrays.asList("a", "a", "a", "a", "b");
        boolean aa = strs.stream().anyMatch(str -> str.equals("a"));
        boolean bb = strs.stream().allMatch(str -> str.equals("a"));
        boolean cc = strs.stream().noneMatch(str -> str.equals("a"));
        long count = strs.stream().filter(str -> str.equals("a")).count();
        System.out.println(aa);
        // TRUE
        System.out.println(bb);
        // FALSE
        System.out.println(cc);
        // FALSE
        System.out.println(count);
        // 4

        Integer sum = numbers1.stream().reduce(2, (x, y) ->  (x * y) * y);
        System.out.println(sum.intValue());

        System.out.println( numbers1.stream().reduce(1,Integer::sum));

        System.out.println(Integer.sum(5,6));

        Optional<Integer> optional = numbers.stream().reduce((a, b) -> (a + b));

        Optional<String> op = Optional.ofNullable("");
        System.out.println(op.isPresent());

        System.out.println(optional.isPresent());
        System.out.println(optional.get());

        System.out.println(numbers1.stream().reduce(Integer::max).get());
        System.out.println(numbers1.stream().reduce(Integer::min).get());
        Optional<Integer> reduce = numbers1.stream().reduce((x, y) -> x > y ? x : y);
        System.out.println(reduce.get());

        System.out.println(numbers1.stream().count());

        int ewew = menu.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println(ewew);
        System.out.println(menu.stream().count());

    }
}
