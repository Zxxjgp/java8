package com.example.demo.java8.java12;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName JavaTest
 * @date 2019/8/26  22:06
 */
public class JavaTest {
    public static void main(String[] args) {
        JavaTest o = new JavaTest();
        Pet p =  new Dog();
        o.setH(p);
/*        p.speak();
        p.speakTo("chao");*/
    }


    private void setH(Pet pet){
        pet.speak();
        System.out.println("\n pet spoke");
    }
}


 class Pet{
    public void speak(){
        System.out.println("..........");
    }
     public void speakTo(String name){
         this.speak();
         System.out.println(name);
     }

 }

class Dog extends Pet{
    @Override
    public void speak(){
        System.out.println("wang");
    }
}