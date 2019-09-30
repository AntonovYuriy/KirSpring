package com.spring.example2;

public class Runner {
    public static void main(String[] args) {
        MySingleton instance1 = MySingleton.getInstance();
        MySingleton instance2 = MySingleton.getInstance();
        System.out.println(instance1.equals(instance2));
    }
}
