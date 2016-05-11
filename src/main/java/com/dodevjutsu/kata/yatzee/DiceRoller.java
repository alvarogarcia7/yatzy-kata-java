package com.dodevjutsu.kata.yatzee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiceRoller {
    private static final int NUMBER_OF_DICE = 5;
    private final DieRoller dieRoller;

    public DiceRoller(DieRoller dieRoller) {
        this.dieRoller = dieRoller;
    }

    public Dice rollAll() {
        List<Roll> rolls = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_DICE; i++) {
            rolls.add(new Roll(Die.nth(i), dieRoller.roll()));
        }

        return new Dice(rolls);
    }

    public Dice roll(Dice previousRoll, List<Die> diceToRoll) {
        for (Die die : diceToRoll) {
            previousRoll = previousRoll.dieAt(die, dieRoller.roll());
        }
        return previousRoll;
    }
}
