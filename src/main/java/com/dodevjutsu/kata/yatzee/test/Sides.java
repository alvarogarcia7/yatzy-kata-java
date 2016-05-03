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

    public int at(int at) {
        return values.get(at);
    }

    public void roll(DiceThrower diceThrower) {
        for (int i = 0; i < 5; i++) {
            put(i, diceThrower.roll());
        }
    }

    public void print(Console console) {
        console.print(String.format("Dice: D1:%s D2:%s D3:%s D4:%s D5:%d",
                getSide(0),
                getSide(1),
                getSide(2),
                getSide(3),
                getSide(4)
        ));
    }

    public int getSide(int at) {
        return this.at(at);
    }
}
