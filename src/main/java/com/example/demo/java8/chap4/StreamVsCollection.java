package com.example.demo.java8.chap4;

import org.springframework.web.server.adapter.AbstractReactiveWebInitializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class StreamVsCollection {

    public static void main(String...args){
/*        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> s = names.stream();
        s.forEach(System.out::println);*/
        // uncommenting this line will result in an IllegalStateException
        // because streams can be consumed only once
        //s.forEach(System.out::println);

        BiFunction<Integer , Integer ,Integer> add = (x , y ) -> x-y;
        System.out.println(add.apply(5,3));

        List<String> g = Arrays.asList("hello","word");
        List<Stream<String>> collect = g.stream()
                .map(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(toList());
        System.out.println(collect.get(1));
        System.out.println(g);

    }
}