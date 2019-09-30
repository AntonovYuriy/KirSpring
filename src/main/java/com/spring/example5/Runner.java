package com.spring.example5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("greater-context.xml");
        Greater bean = context.getBean(Greater.class);

        bean.great();

        bean.saySmth();
    }
}
