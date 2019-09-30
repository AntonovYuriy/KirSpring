package com.spring.example5;

import javax.annotation.PostConstruct;

public class HiGreater implements Greater {
    @InjectRandomInt(min = 2, max = 5)
    private int quantity;

    @Override
    @Synchronized
    @PostSynchConstruct
    public void great() {
        for (int index = 0; index < quantity; index++) {
            System.out.println("Hi");
        }
    }

    @Override
    public void saySmth() {
        System.out.println("Smth");
    }


}
