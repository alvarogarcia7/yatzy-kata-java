package com.dodevjutsu.kata.yatzee.test;

import com.dodevjutsu.kata.yatzee.*;

public class Yatzee {
    private final Console console;
    private final InputReader inputReader;
    private DiceRoller diceRoller;

    /**
     *
     * @param console
     * @param dieRoller a port
     * @param inputReader a port
     */
    public Yatzee(Console console, DieRoller dieRoller, InputReader inputReader) {
        this.console = console;
        diceRoller = new DiceRoller(dieRoller);
        this.inputReader = inputReader;
    }

    public void play() {
        console.print("Category: Ones");
        Dice rolls = diceRoller.rollAll();
        console.print(rolls.asString());
        console.print("[1] Dice to re-run:");
        rolls = diceRoller.roll(rolls, inputReader.getDiceToReRun());
        console.print(rolls.asString());
    }

}
