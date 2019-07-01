package com.example.demo.java8.chap6;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Testone
 * @date 2019/6/26  18:23
 */
public class Testone {
    public static void main(String[] args) {
     //  reduce(999999999);
        reduceq(99999999);
       // System.out.println(reduceq(999999999));10927

        System.out.println("Iterative sum done in:" +
                measureSumPerf(ParallelStreams::iterativeSum, 10_000_000) + " msecs");

        System.out.println("Sequential sum done in:" +
                measureSumPerf(ParallelStreams::sequentialSum, 10_000_000) + " msecs");

    }

    //单线程
    public static long reduce( long g){
        long l = System.currentTimeMillis();
        Long reduce = Stream.iterate(2L, x -> x + 1).limit(g).reduce(0L, Long::sum);
        System.out.println(System.currentTimeMillis()-l);
        System.out.println("11111111111111111111111111111111111111111");
        return reduce;
    }

    //单线程
    public static long reduceq( long g){
        long l = System.currentTimeMillis();
        Long reduce = Stream.iterate(2L, x -> x + 1).limit(g).parallel().reduce(0L, Long::sum);
        System.out.println(System.currentTimeMillis()-l);
        System.out.println("ddddddddddddddddddddddddddddddddddddddddddddd");
        return reduce;
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }


    public static  long rangedSum(long n){
        return LongStream.rangeClosed(1,n ).reduce(0,Long::sum);
    }

}
