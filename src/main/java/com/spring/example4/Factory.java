package com.spring.example4;

public class Factory {

    public AnotherBean getInstance() {
        System.out.println("In Factory method");

        return new AnotherBean();
    }
}
