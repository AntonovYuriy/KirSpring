package com.spring.example3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Runner {
    public static void main(String[] args) throws IOException {
        InputStream fis = Runner.class.getClassLoader().getResourceAsStream("example.properties");
        Properties props = new Properties();
        props.load(fis);

        MyProperties properties = new MyProperties();

        properties.setName(props.getProperty("example.name"));
        properties.setQuantity(Integer.valueOf(props.getProperty("example.quantity")));

        System.out.println(properties);
    }
}
