package com.example.demo.java8.chap7;

import com.example.demo.utils.ForkJoinSumCalculator;

import java.util.function.Function;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Test
 * @date 2019/7/13  23:26
 */
public class Test {
    public static void main(String[] args) {
/*        long l = measurePerf(ParallelStreams::iterativeSum, 100_000_00L);
        System.out.println("执行的时间"+l);
        long ll = measurePerf(ParallelStreams::sequentialSum, 100_000_00L);
        System.out.println("执行的时间"+ll);*/

        System.out.println("ForkJoin sum done in: " + measurePerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000L) + " msecs" );
        boolean whitespace = Character.isWhitespace("h ell eree".charAt(1));
        System.out.println("h ell eree".substring(1));
        System.out.println(whitespace);


    }
    public static <T, R> long measurePerf(Function<T, R> f, T input) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            R result = f.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + result);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
}
