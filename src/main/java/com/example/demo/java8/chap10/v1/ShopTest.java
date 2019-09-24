package com.example.demo.java8.chap10.v1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName ShopTest
 * @date 2019/8/4  18:53
 */
public class ShopTest {
    List<Shop> shopList = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));
    public static void main(String[] args) {
        ShopTest d = new ShopTest();
        System.out.println(d.getPrice11("Buy"));

    }

    public List<String> findPrices(String productName){
        return shopList.parallelStream().map( shop -> String.format("%s price is %.2f",
                shop.getName(), shop.getPrice(productName))).collect(Collectors.toList());
    }

    public List<String> getPrice11(String productName){
        List<CompletableFuture<String>> priceFutures =
                shopList.parallelStream().filter(x -> x.getName().equals(productName)).map( shop -> CompletableFuture.supplyAsync(()
                ->String.format("%s price is %.2f",
                shop.getName(), shop.getPrice(productName)) )
        ).collect(Collectors.toList());

        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }
}
