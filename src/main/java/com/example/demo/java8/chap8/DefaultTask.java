package com.example.demo.java8.chap8;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName DefaultTask
 * @date 2019/7/14  23:52
 */
public class DefaultTask implements Task1 {
    @Override
    public void execute() {
        System.out.println("qqqqqqq");
    }

    @Override
    public void remove() {
        System.out.println("111111111111111111");
    }
}
