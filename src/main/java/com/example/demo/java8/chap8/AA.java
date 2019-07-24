package com.example.demo.java8.chap8;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName AA
 * @date 2019/7/15  0:12
 */
public interface AA {
    default void hello(){
        System.out.println("from AAAA");
    }
}
