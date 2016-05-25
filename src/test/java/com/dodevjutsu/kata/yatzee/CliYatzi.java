package com.dodevjutsu.kata.yatzee;

public class CliYatzi {
    private final Console console;

    public CliYatzi (final Console console) {
        this.console = console;
    }

    public void run () {
        console.print("Category: Ones");
        console.print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
    }
}
