package com.dodevjutsu.kata.yatzee;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    private List<Roll> dice;

    public Dice(List<Roll> dice) {
        this.dice = dice;
    }

    public Dice dieAt(Die die, int side) {
        List<Roll> result = replaceByDie(die, side);
        return new Dice(result);
    }

    private List<Roll> replaceByDie(Die die, int side) {
        List<Roll> result = new ArrayList<>();
        for (Roll roll : dice) {
            if (roll.die().equals(die)) {
                roll = new Roll(die, side);
            }
            result.add(roll);
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Dice{");
        sb.append("dice=").append(dice);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dice dice = (Dice) o;

        return this.dice != null ? this.dice.equals(dice.dice) : dice.dice == null;

    }

    @Override
    public int hashCode() {
        return dice != null ? dice.hashCode() : 0;
    }

    public String asString() {
        StringBuilder representation = new StringBuilder();
        representation.append("Dice: ");
        dice.stream().forEach(current -> representation.append(current.asString() + " "));
        return representation.toString().trim();
    }
}
