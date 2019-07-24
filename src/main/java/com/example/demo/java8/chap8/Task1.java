package com.example.demo.java8.chap8;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Task1
 * @date 2019/7/14  16:57
 */
public interface Task1 {
    public void execute();
    default void remove(){
        System.out.println("我是默认方法");
    }
}
