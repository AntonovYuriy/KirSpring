package com.spring.example1;

public class Runner {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        JavaClass javaClass = new JavaClass();
        javaClass = null;
        System.gc();
    }
}
