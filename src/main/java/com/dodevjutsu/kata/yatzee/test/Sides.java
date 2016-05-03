package com.dodevjutsu.kata.yatzee.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sides {

    private Map<Integer, Integer> values;

    public Sides() {
        values = new HashMap<>();
    }

    private void put(int index, int value) {
        values.put(index, value);
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

    private int getSide(int at) {
        return values.get(at);
    }

    public void roll(List<Integer> integers, DiceThrower diceThrower) {
        for (Integer dieNumber : integers) {
            values.put(toIndex(dieNumber), diceThrower.roll());
        }
    }

    private int toIndex(Integer dieNumber) {
        final int dieIndex = dieNumber - 1;
        return dieIndex;
    }

    public void reRun(Console console, final DiceThrower diceThrower) {
        reRunUserSides(console, diceThrower);
    }

    private void reRunUserSides(Console console, final DiceThrower diceThrower) {
        final String diceToReRunRepresentation = console.read();
        final List<Integer> integers = parseDiceToReRun(diceToReRunRepresentation);
        this.roll(integers, diceThrower);
    }

    private List<Integer> parseDiceToReRun(String diceToReRunRepresentation) {
        String[] diceToReRunAsString = diceToReRunRepresentation.split(" ");
        return Stream.of(diceToReRunAsString).map(x->x.substring(1)).map(Integer::valueOf).collect(Collectors.toList());
    }
}
