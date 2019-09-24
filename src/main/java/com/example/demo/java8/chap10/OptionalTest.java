package com.example.demo.java8.chap10;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName OptionalTest
 * @date 2019/7/30  19:56
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<Car> optional = Optional.empty();
        System.out.println(optional.isPresent());
        Car v = new Car();
        Optional<Car> gg = Optional.of(v);
        System.out.println(optional);

    }
}
