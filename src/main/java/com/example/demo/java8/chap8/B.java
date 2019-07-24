package com.example.demo.java8.chap8;

public interface B extends A {
 default void hello() { 
 System.out.println("Hello from B"); 
 } 
} 