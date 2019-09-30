package com.spring.example2;

import java.util.Objects;
import java.util.Random;

public class MySingleton {
    private static MySingleton instance;
    private int value = new Random().nextInt();

    private MySingleton(){}

    public static MySingleton getInstance() {
        if (instance == null) {
            synchronized (MySingleton.class){
                if (instance == null) {
                    instance = new MySingleton();
                }
            }
        }

        return instance;
    }

    @Override
    public boolean equals(Object o) {
        MySingleton another = (MySingleton) o;
        return another.value == this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
