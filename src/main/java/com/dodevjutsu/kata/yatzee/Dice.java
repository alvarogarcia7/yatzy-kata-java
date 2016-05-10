package com.dodevjutsu.kata.yatzee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Dice {
    private final List<Integer> sides;

    public Dice(List<Integer> sides) {
        this.sides = sides;
    }

    public static Dice fromDice(List<Die> dice){
        return new Dice(dice.stream().map(x -> x.value()).collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dice dice = (Dice) o;

        return sides != null ? sides.equals(dice.sides) : dice.sides == null;

    }

    @Override
    public int hashCode() {
        return sides != null ? sides.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Dice");
        sb.append(sides);
        return sb.toString();
    }

    public Dice roll(Dice diceToReRun, DieRoller dieRoller) {
        Integer[] rollValues = sides.toArray(new Integer[0]);
        for (Integer die : diceToReRun.sides) {
            rollValues[die - 1] = dieRoller.roll();
        }
        return new Dice(Arrays.asList(rollValues));
    }
}
