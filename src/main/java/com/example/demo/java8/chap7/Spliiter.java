package com.example.demo.java8.chap7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Spliiter
 * @date 2019/7/14  15:42
 */
public class Spliiter
{
    public static class TestSpliterator {
        public static void main(String[] args) {

            List<String> arrs = new ArrayList<>();
            arrs.add("a");
            arrs.add("b");
            arrs.add("c");
            arrs.add("d");
            arrs.add("e");
            arrs.add("f");
            arrs.add("h");
            arrs.add("i");
            arrs.add("j");
     /*       Spliterator<String> a =  arrs.spliterator();
            //此时结果：a:0-9（index-fence）
            Spliterator<String> b = a.trySplit();

            //此时结果：b:4-9,a:0-4
            Spliterator<String> c = a.trySplit();
            //此时结果：c:4-6,b:4-9,a:6-9
            Spliterator<String> d = a.trySplit();*/
            //此时结果：d:6-7,c:4-6,b:4-9,a:7-9
            Spliterator<String> stringSpliterator = arrs.stream().spliterator().trySplit().trySplit();

            List<String> list = Arrays.asList("Apple", "Banana", "Orange");


            Spliterator<String> s = list.spliterator();
            Spliterator<String> s1 = s.trySplit();

            s.forEachRemaining(System.out::println);
            System.out.println("-- traversing the other half of the spliterator --- ");
            s1.forEachRemaining(System.out::println);


            System.out.println(stringSpliterator);


        }
    }
}
