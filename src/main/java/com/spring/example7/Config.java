package com.spring.example7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Configuration
@PropertySource("atm.properties")
public class Config {
    @Value("#{'${atm.currency.notes.list}'.split(',')}")
    private List<String> notes;

    @Bean
    public AtmProcessor atmProcessor() {
        Collections.sort(notes, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2) - Integer.parseInt(o1);
            }
        });
        AtmProcessor root = null;
        AtmProcessor prev = null;
        for (String note : notes) {
            AtmProcessor curr = new AtmProcessor(Integer.parseInt(note));
            if (root == null) {
                root = curr;
            }
            if (prev != null) {
                prev.setNext(curr);
            }
            prev = curr;
        }

        return root;
    }
}
