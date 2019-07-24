package com.example.demo.java8.chap8;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName StateCode
 * @date 2019/7/14  22:28
 */

public enum StateCode {
    SUCCESS(99),
    FAIL(100);
    private int value;

    StateCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Boolean check(int mask){
        return (value == mask);
    }
}
