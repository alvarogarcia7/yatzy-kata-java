package com.dodevjutsu.kata.yatzee.test;

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
        sides.reRun(console, diceThrower);
        sides.print(console);
        console.print("[2] Dice to re-run: ");
        console.read();
    }
}
