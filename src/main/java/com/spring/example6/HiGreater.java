package com.spring.example6;

@DeprecatedNewImpl(newImpl = HelloGreater.class)
public class HiGreater implements Greater {
    @Override
    public void great() {
        System.out.println("Hi");
    }
}
