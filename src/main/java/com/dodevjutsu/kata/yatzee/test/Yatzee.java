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
        console.print(String.format("Dice: D1:%s D2:%s D3:%s D4:%s D5:%d",
                diceThrower.roll(),
                diceThrower.roll(),
                diceThrower.roll(),
                diceThrower.roll(),
                diceThrower.roll()
                ));
    }
}
