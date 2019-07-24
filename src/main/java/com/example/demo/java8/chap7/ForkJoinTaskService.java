package com.example.demo.java8.chap7;

import java.util.concurrent.RecursiveTask;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName ForkJoinTaskService
 * @date 2019/7/14  0:05
 */
public class ForkJoinTaskService extends RecursiveTask<Long> {

    public static final long THRESHOLD = 10_000;

    private final long[] numbers;
    private final int start;
    private final int end;

    public ForkJoinTaskService(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinTaskService(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        int length = end -start;
        if ( length < THRESHOLD ) {
            //开始求和
            return sum();
        }
        ForkJoinTaskService leftJoin = new ForkJoinTaskService(numbers,start,start + length/2);
        leftJoin.fork();

        ForkJoinTaskService rightJoin = new ForkJoinTaskService(numbers,start+length/2,end);
        Long rightResult = rightJoin.compute();
        Long leftResult = leftJoin.join();
        return rightResult + leftResult;
    }

    private long sum(){
        long sum = 0;
        for (int i = start; i < end ; i++) {
            sum += numbers[i];
        }
        return sum;
    }

}
