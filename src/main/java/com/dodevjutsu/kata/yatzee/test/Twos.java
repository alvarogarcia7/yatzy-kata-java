package com.dodevjutsu.kata.yatzee.test;

public class Twos implements Throw {

    @Override
    public void play(Console console, Sides sides, DiceThrower diceThrower) {
        console.print("Category: Twos");
        sides.roll(diceThrower);
        sides.print(console);
        console.print("[1] Dice to re-run: ");
        sides.reRun(console, diceThrower);
        sides.print(console);
        console.print("[2] Dice to re-run: ");
        sides.reRun(console, diceThrower);
        sides.print(console);
    }
}
