package com.spring.example7;

import javafx.util.Pair;

import java.util.List;

public class AtmProcessor {
    private int note;
    private AtmProcessor next;

    public AtmProcessor(int note) {
        this.note = note;
    }

    public void setNext(AtmProcessor next) {
        this.next = next;
    }

    public void process(int amount, List<Pair<Integer, Integer>> result) {
        if (amount > note) {
            int quantity = amount / note;
            amount -= note * quantity;
            result.add(new Pair(note, quantity));
        }
        if (amount > 0 && next != null) {
            next.process(amount, result);
        }
    }

}
