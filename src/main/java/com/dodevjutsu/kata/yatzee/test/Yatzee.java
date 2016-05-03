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
        for (int i = 0; i < sides.length; i++) {
            final int roll = diceThrower.roll();
            sides[i] = roll;
        }
        console.print(String.format("Dice: D1:%s D2:%s D3:%s D4:%s D5:%d",
                sides[0],
                sides[1],
                sides[2],
                sides[3],
                sides[4]
        ));
        console.print("[1] Dice to re-run: ");
        console.read(); // 1 2 4 = 0 1 3
        sides[0] = diceThrower.roll();
        sides[1] = diceThrower.roll();
        sides[3] = diceThrower.roll();
        console.print(String.format("Dice: D1:%s D2:%s D3:%s D4:%s D5:%d",
                sides[0],
                sides[1],
                sides[2],
                sides[3],
                sides[4]
        ));
    }
}
