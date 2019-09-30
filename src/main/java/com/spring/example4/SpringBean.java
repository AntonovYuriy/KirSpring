package com.spring.example4;

import com.spring.example2.MySingleton;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Objects;
import java.util.Random;

@Component
public class SpringBean implements InitializingBean {
    @Value("${example.quantity}")
    private int quantity;

    @Value("${example.name}")
    private String name;

    @Autowired
    private AnotherBean anotherBean;
    private int value = new Random().nextInt();

    public SpringBean() {
        System.out.println(this);
    }

    public void init() {
        System.out.println(this);
    }

    @PostConstruct
    public void initAnnotation() {
        System.out.println(this);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println(this);
    }

    public SpringBean(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    public AnotherBean getAnotherBean() {
        return anotherBean;
    }

    public void setAnotherBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SpringBean{" +
                "quantity=" + quantity +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        SpringBean another = (SpringBean) o;
        return another.value == this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
