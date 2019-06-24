package com.example.demo.java8.chart3;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Sorting {

    public static void main(String...args){

        // 1
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80,"green"),new Apple(125,"white"), new Apple(155, "green"), new Apple(120, "red")));

        // [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(30, "green"));
        
        // 2
        // [Apple{color='green', weight=30}, Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2){
                return a1.getWeight().compareTo(a2.getWeight()); 
        }});
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(20, "red"));
        
        // 3
        // [Apple{color='red', weight=20}, Apple{color='green', weight=30}, Apple{color='green', weight=155}]
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);
        
        // reshuffling things a little
        inventory.set(1, new Apple(10, "red"));
        
        // 4
        // [Apple{color='red', weight=10}, Apple{color='red', weight=20}, Apple{color='green', weight=155}]
        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        System.out.println(inventory);

        List<String> red = inventory.stream().filter(x -> x.getColor().equals("red")).sorted(comparing(Apple::getWeight)).distinct().map(Apple::getColor).collect(Collectors.toList());
        System.out.println(red.size()+"*****");
        Predicate<Apple> redApple =  (Apple a) -> a.getColor().equals("red");
        Predicate<Apple> or = redApple.and(x -> x.getWeight() > 10);

        List<Apple>  GG = inventory.stream().filter(or).collect(Collectors.toList());
        System.out.println(GG);

        Predicate<Apple> notRedApple = redApple.negate();
        List<Apple>  GM = inventory.stream().filter(notRedApple).collect(Collectors.toList());
        System.out.println(GM);
        Function<Integer, Integer> f = x -> x + 7;

        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        System.out.println(h.apply(5));

        Function<String,String> functionHeader = Letter::addHeader;
        Function<String,String> funadd = functionHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
        System.out.println(functionHeader.apply("1111111111111"));
        System.out.println(funadd.apply("labda"));
        System.out.println(Integer.compare(2,1));
    }

    public static class Apple {
        private Integer weight = 0;
        private String color = "";

        public Apple(Integer weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                   "color='" + color + '\'' +
                   ", weight=" + weight +
                   '}';
        }
    }

    static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }
    static class Letter{
        public static String addHeader(String text){
            return "From Raoul, Mario and Alan: " + text;
        }
        public static String addFooter(String text){
            return text + " Kind regards";
        }
        public static String checkSpelling(String text){
            return text.replaceAll("labda", "lambda");
        }
        public String test(){
            return "";
        }
    }

    public static class Dish {
        private final String name;
        private final boolean vegetarian;
        private final int calories;
        private final Type type;
        public Dish(String name, boolean vegetarian, int calories, Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.type = type;
        }
        public String getName() {
            return name;
        }
        public boolean isVegetarian() {
            return vegetarian;
        }
        public int getCalories() {
            return calories;
        }
        public Type getType() {
            return type;
        }
        @Override
        public String toString() {
            return name;
        }
        public enum Type { MEAT, FISH, OTHER }
    }

}
