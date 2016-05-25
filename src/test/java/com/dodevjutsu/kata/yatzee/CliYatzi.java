package com.dodevjutsu.kata.yatzee;

public class CliYatzi {
    private final Console console;
    private final UserInput userInput;

    public CliYatzi (final Console console, final UserInput userInput) {
        this.console = console;
        this.userInput = userInput;
    }

    public void run () {
        console.print("Category: Ones");
        console.print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
        console.print("[1] Dice to re-run:");
        userInput.read();
        console.print("Dice: D1:1 D2:5 D3:1 D4:2 D5:1");
        userInput.read();
    }
}
