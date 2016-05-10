package com.dodevjutsu.kata.yatzee.test;

import com.dodevjutsu.kata.yatzee.ConsoleInputReader;
import com.dodevjutsu.kata.yatzee.DieRoller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Yatzee {
    private final Console console;
    private final ConsoleInputReader consoleInputReader;
    private DieRoller dieRoller;

    public Yatzee(Console console, DieRoller dieRoller, ConsoleInputReader consoleInputReader) {
        this.console = console;
        this.dieRoller = dieRoller;
        this.consoleInputReader = consoleInputReader;
    }

    public void play() {
        console.print("Category: Ones");
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            rolls.add(dieRoller.roll());
        }
        final String rolledDiceMessage = asRolledMessage(rolls);
        console.print(rolledDiceMessage);
        console.print("[1] Dice to re-run:");
        final List<Integer> diceToReRun = consoleInputReader.getDiceToReRun();
        Integer[] rollValues = rolls.toArray(new Integer[0]);
        for (Integer die : diceToReRun) {
            rollValues[die - 1] = dieRoller.roll();
        }
        rolls = Arrays.asList(rollValues);
        final String reRunDiceMessage = asRolledMessage(rolls);
        console.print(reRunDiceMessage);
    }

    private String asRolledMessage(List<Integer> rolls) {
        return String.format("Dice: D1:%d D2:%d D3:%d D4:%d D5:%d",
                    rolls.toArray(new Integer[0]));
    }

}
