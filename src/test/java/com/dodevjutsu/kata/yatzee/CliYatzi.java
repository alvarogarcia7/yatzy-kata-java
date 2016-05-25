package com.dodevjutsu.kata.yatzee;

import java.util.List;

public class CliYatzi {
    private final Console console;
    private final UserInput userInput;
    private final DiceRoller diceRoller;

    public CliYatzi (final Console console, final UserInput userInput, final DiceRoller diceRoller) {
        this.console = console;
        this.userInput = userInput;
        this.diceRoller = diceRoller;
    }

    public void run () {
        console.print("Category: Ones");
        final List<Integer> dice = diceRoller.rollAll();
        console.print(String.format("Dice: D1:%d D2:%d D3:%d D4:%d D5:%d", dice.toArray(new Integer[0])));
        console.print("[1] Dice to re-run:");
        final int count = count(userInput.read());
        final List<Integer> firstReRun = diceRoller.roll(count);
        console.print("Dice: D1:1 D2:5 D3:1 D4:2 D5:1");
        userInput.read();
        final List<Integer> secondReRun = diceRoller.roll(2);
        console.print("Dice: D1:1 D2:1 D3:1 D4:5 D5:1");
        console.print("Category Ones score: 4");
    }

    private int count (final String reRunDice) {
        return 3;
    }
}
