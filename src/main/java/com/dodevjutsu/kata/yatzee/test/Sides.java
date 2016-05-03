package com.dodevjutsu.kata.yatzee.test;

import java.util.HashMap;
import java.util.Map;

public class Sides {

    private Map<Integer, Integer> values;

    public Sides() {
        values = new HashMap<>();
    }

    public void put(int index, int value) {
        values.put(index, value);
    }

    public int size() {
        return values.size();
    }

    public int at(int at) {
        return values.get(at);
    }

    public void roll(DiceThrower diceThrower) {
        for (int i = 0; i < 5; i++) {
            put(i, diceThrower.roll());
        }
    }
}
