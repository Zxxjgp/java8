package com.example.demo.java8.chap10;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor

public class Insurance {
   /* public static void main(String[] args) {
        String str = "/wqewqewq/ewqewqewq/11111.JPG";
        String suffix = str.substring(str.lastIndexOf(".") + 1);
        String s = suffix.toUpperCase();
        List<String> stringList = Arrays.asList("JPEG", "JPG", "PNG","GIF","BMP","SVG");

        if (!stringList.contains(s)) {
            System.out.println("11");
        }
    }*/

   private String name;
}