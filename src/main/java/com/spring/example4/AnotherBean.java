package com.spring.example4;

import org.springframework.stereotype.Component;

@Component
public class AnotherBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
