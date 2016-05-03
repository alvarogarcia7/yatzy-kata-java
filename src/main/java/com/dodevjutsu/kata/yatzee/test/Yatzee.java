package com.dodevjutsu.kata.yatzee.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Yatzee {
    private final Console console;
    private final DiceThrower diceThrower;
    private final int[] sides;

    public Yatzee(Console console, DiceThrower diceThrower) {
        this.console = console;
        this.diceThrower = diceThrower;
        sides = new int[5];
    }

    public void play() {
        console.print("Category: Ones");
        rollAllSides();
        printSides();
        console.print("[1] Dice to re-run: ");
        reRunUserSides();
        printSides();
        console.print("[2] Dice to re-run: ");
        console.read();
    }

    private void reRunUserSides() {
        final String diceToReRunRepresentation = console.read();
        for (Integer dieNumber : parseDiceToReRun(diceToReRunRepresentation)) {
            getSides()[toIndex(dieNumber)] = diceThrower.roll();
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

    private void rollAllSides() {
        for (int i = 0; i < getSides().length; i++) {
            final int roll = diceThrower.roll();
            getSides()[i] = roll;
        }
    }

    private void printSides() {
        console.print(String.format("Dice: D1:%s D2:%s D3:%s D4:%s D5:%d",
                getSides()[0],
                getSides()[1],
                getSides()[2],
                getSides()[3],
                getSides()[4]
        ));
    }

    public int[] getSides() {
        return sides;
    }
}
