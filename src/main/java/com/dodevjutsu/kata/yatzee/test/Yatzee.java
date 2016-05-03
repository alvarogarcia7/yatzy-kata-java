package com.dodevjutsu.kata.yatzee.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Yatzee {
    private final Console console;
    private final DiceThrower diceThrower;
    private Sides sides;

    public Yatzee(Console console, DiceThrower diceThrower) {
        this.console = console;
        this.diceThrower = diceThrower;
        sides = new Sides();
    }

    public void play() {
        console.print("Category: Ones");
        sides.roll(diceThrower);
        sides.print(console);
        console.print("[1] Dice to re-run: ");
        reRunUserSides();
        sides.print(console);
        console.print("[2] Dice to re-run: ");
        console.read();
    }

    private void reRunUserSides() {
        final String diceToReRunRepresentation = console.read();
        final List<Integer> integers = parseDiceToReRun(diceToReRunRepresentation);
        sides.roll(integers, diceThrower);
    }

    private List<Integer> parseDiceToReRun(String diceToReRunRepresentation) {
        String[] diceToReRunAsString = diceToReRunRepresentation.split(" ");
        return Stream.of(diceToReRunAsString).map(x->x.substring(1)).map(Integer::valueOf).collect(Collectors.toList());
    }
}
