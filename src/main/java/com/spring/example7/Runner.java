package com.spring.example7;

import javafx.util.Pair;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AtmProcessor bean = context.getBean(AtmProcessor.class);
        List<Pair<Integer, Integer>> result = new ArrayList();
        bean.process(398, result);

        System.out.println(result);
    }
}
