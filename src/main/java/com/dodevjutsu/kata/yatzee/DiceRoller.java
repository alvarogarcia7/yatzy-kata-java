package com.dodevjutsu.kata.yatzee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiceRoller {
    private final DieRoller dieRoller;

    public DiceRoller(DieRoller dieRoller) {
        this.dieRoller = dieRoller;
    }

    public Dice rollAll() {
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            rolls.add(dieRoller.roll());
        }
        return new Dice(rolls);
    }

    public Dice roll(Dice previousDice, Dice diceToReRun) {
        return previousDice.roll(diceToReRun, this.dieRoller);
    }
}
