package com.dodevjutsu.kata.yatzee.test;

import org.bouncycastle.util.io.Streams;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Yatzee {
    private final Console console;
    private final DiceThrower diceThrower;

    public Yatzee(Console console, DiceThrower diceThrower) {
        this.console = console;
        this.diceThrower = diceThrower;
    }

    public void play() {
        console.print("Category: Ones");
        int[] sides = new int[5];
        rollAllSides(sides);
        printSides(sides);
        console.print("[1] Dice to re-run: ");
        reRunUserSides(sides);
        printSides(sides);
        console.print("[2] Dice to re-run: ");
        console.read();
    }

    private void reRunUserSides(int[] sides) {
        final String diceToReRunRepresentation = console.read();
        final List<Integer> diceToReRun = parseDiceToReRun(diceToReRunRepresentation);
        for (Integer dieNumber : diceToReRun) {
            sides[toIndex(dieNumber)] = diceThrower.roll();
        }
    }

    private List<Integer> parseDiceToReRun(String diceToReRunRepresentation) {
        String[] diceToReRunAsString = diceToReRunRepresentation.split(" ");
        return Stream.of(diceToReRunAsString).map(x->x.substring(1)).map(Integer::valueOf).collect(Collectors.toList());
    }

    private int toIndex(Integer dieNumber) {
        final int dieIndex = dieNumber - 1;
        return dieIndex;
    }

    private void rollAllSides(int[] sides) {
        for (int i = 0; i < sides.length; i++) {
            final int roll = diceThrower.roll();
            sides[i] = roll;
        }
    }

    private void printSides(int[] sides) {
        console.print(String.format("Dice: D1:%s D2:%s D3:%s D4:%s D5:%d",
                sides[0],
                sides[1],
                sides[2],
                sides[3],
                sides[4]
        ));
    }
}
