package com.example.demo.java8.chap8;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.assertEquals;
import static org.mockito.internal.util.collections.ListUtil.filter;

public class StrategyMain {


    public static void main(String[] args) {
/*        // old school
        Validator v1 = new Validator(new IsNumeric());
        System.out.println(v1.validate("aaaa"));
        Validator v2 = new Validator(new IsAllLowerCase ());
        System.out.println(v2.validate("bbbb"));


        // with lambdas

        ValidationStrategy p = new ValidationStrategy() {
            @Override
            public boolean execute(String s) {
                return true;
            }
        };
        System.out.println(p.execute("1111"));*/
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> even = filter(numbers, i -> i % 2 == 0);
        List<Integer> smallerThanThree = filter(numbers, i -> i < 3);
        assertEquals(Arrays.asList(1, 3), even);
        assertEquals(Arrays.asList(1, 2), smallerThanThree);

    }

    interface ValidationStrategy {
        public boolean execute(String s);
    }

    static private class IsAllLowerCase implements ValidationStrategy {
        @Override
        public boolean execute(String s){
            return s.matches("[a-z]+");
        }
    }
    static private class IsNumeric implements ValidationStrategy {
        @Override
        public boolean execute(String s){
            return s.matches("\\d+");
        }
    }

    static private class Validator{
        private final ValidationStrategy strategy;
        public Validator(ValidationStrategy v){
            this.strategy = v;
        }
        public boolean validate(String s){
            return strategy.execute(s); }
    }


    /**
     * 模板方法 不同的銀行集成这个类去实现不同的方法
     */
    abstract class Onlinebanking{
        public void  processCustomer(String id){
            String custMassger = "客户信息0";
            makeCustomerHappy(custMassger);
        }
        abstract void makeCustomerHappy(String custMassge);
    }

    /**
     * 模板的使用每一个银行都去实现他们自己的代码
     */
    class SDBanking extends Onlinebanking{
        @Override
        void makeCustomerHappy(String custMassge) {

        }
    }

    /**
     * 使用lamdba
     */
    public void processCustomer(int id, Consumer<String> makeCustomerHappy){
        String custMas = "数据库通过id去查找客户的信息";
        makeCustomerHappy.accept(custMas);
    }


}
