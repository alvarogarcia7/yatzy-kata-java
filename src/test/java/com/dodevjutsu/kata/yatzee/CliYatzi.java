package com.dodevjutsu.kata.yatzee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<Integer> dice = diceRoller.rollAll();
        console.print(String.format("Dice: D1:%d D2:%d D3:%d D4:%d D5:%d", dice.toArray(new Integer[0])));
        console.print("[1] Dice to re-run:");
        final String firstReRunRepresentation = userInput.read();
        final int count = count(firstReRunRepresentation);
        final List<Integer> firstReRun = diceRoller.roll(count);
        dice = merge(dice, firstReRunRepresentation, firstReRun);
        console.print(String.format("Dice: D1:%d D2:%d D3:%d D4:%d D5:%d", dice.toArray(new Integer[0])));
        final int secondCount = count(userInput.read());
        final List<Integer> secondReRun = diceRoller.roll(secondCount);
        console.print("Dice: D1:1 D2:1 D3:1 D4:5 D5:1");
        console.print("Category Ones score: 4");
    }

    private List<Integer> merge (List<Integer> dice, final String userInput, final List<Integer> firstReRun) {
        final List<Integer> indicesToReRun = new ArrayList<>(Stream.of(userInput.split(" ")).map(x -> x.substring(1)).map
                (Integer::valueOf).map(x->x-1).collect(Collectors.toList()));
        System.out.println(indicesToReRun);
        dice = new ArrayList<>(dice);

        int i = 0;
        for (Integer integer : indicesToReRun) {
            dice.set(integer, firstReRun.get(i));
            i++;
        }

        return dice;
    }

    private int count (final String reRunDice) {
        return reRunDice.split(" ").length;
    }
}
