package com.example.demo.java8.chap10.v1;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;


public class Shop {

    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread( () -> {
                    double price = calculatePrice(product);
                    futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    public Future<Double> getPrice1(String productName){
        CompletableFuture<Double> f = new CompletableFuture<>();
        new Thread(() ->{
            try {
                Double price = calculatePrice(productName);
                f.complete(price);
            } catch (Exception e) {
                f.completeExceptionally(e);
            }
        }).start();
        return f;
    }

    public Future<Double> getPrice2(String productName){
        return CompletableFuture.supplyAsync(() -> calculatePrice(productName)
       );
    }


    public String getName() {
        return name;
    }

    public static void delay() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
