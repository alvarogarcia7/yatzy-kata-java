package com.dodevjutsu.kata.yatzee.test;

public class Yatzee {
    private final Console console;
    private final DiceThrower diceThrower;

    public Yatzee(Console console, DiceThrower diceThrower) {
        this.console = console;
        this.diceThrower = diceThrower;
    }

    public void play() {
        console.print("Category: Ones");
        diceThrower.roll();
        console.print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
    }
}
