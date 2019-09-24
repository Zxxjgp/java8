package com.example.demo.java8.chap10;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Random;

import static com.example.demo.java8.chap10.Util.format;
import static com.example.demo.java8.chap10.v1.Shop.delay;


public class Discount {

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }
    private static double apply(double price, Code code) {
        delay();
        return format(price * (100 - code.percentage) / 100);
    }

    public static void main(String[] args) {
        Code[] values = Code.values();
        System.out.println(values[0]);
        Random random = new Random();
        Discount.Code code = Discount.Code.values()[
                random.nextInt(Discount.Code.values().length)];
        System.out.println(code);
    }
}