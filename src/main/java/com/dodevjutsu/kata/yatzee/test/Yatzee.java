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
        console.read(); // 1 2 4 = 0 1 3
        sides[0] = diceThrower.roll();
        sides[1] = diceThrower.roll();
        sides[3] = diceThrower.roll();
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
