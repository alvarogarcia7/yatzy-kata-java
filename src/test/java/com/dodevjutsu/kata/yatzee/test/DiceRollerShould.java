package com.dodevjutsu.kata.yatzee.test;

import com.dodevjutsu.kata.yatzee.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DiceRollerShould {

    Mockery context = new Mockery();

    @Test
    public void roll_all_dice() throws Exception {
        DieRoller dieRoller = context.mock(DieRoller.class);
        DiceRoller diceRoller = new DiceRoller(dieRoller);

        context.checking(new Expectations() {{
            exactly(5).of(dieRoller).roll();
            will(onConsecutiveCalls(
                    returnValue(1), returnValue(2), returnValue(3), returnValue(4), returnValue(5)));
        }});


        final Dice dice = dice(new Roll(Die.FIRST, 1),
                new Roll(Die.SECOND, 2),
                new Roll(Die.THIRD, 3),
                new Roll(Die.FOURTH, 4),
                new Roll(Die.FIFTH, 5));
        assertThat(diceRoller.rollAll(), is(dice));
    }

    private Dice dice(Roll... rolls) {
        return new Dice(Arrays.asList(rolls));
    }

    @Test
    public void roll_some_dice() throws Exception {
        DieRoller dieRoller = context.mock(DieRoller.class);
        DiceRoller diceRoller = new DiceRoller(dieRoller);

        context.checking(new Expectations() {{
            exactly(5).of(dieRoller).roll();
            will(onConsecutiveCalls(
                    returnValue(1), returnValue(3)));
        }});

        final Dice previousRoll = dice(new Roll(Die.FIRST, 5),
                new Roll(Die.SECOND, 5),
                new Roll(Die.THIRD, 5),
                new Roll(Die.FOURTH, 5),
                new Roll(Die.FIFTH, 5));

        final Dice expectedRoll = dice(new Roll(Die.FIRST, 1),
                new Roll(Die.SECOND, 3),
                new Roll(Die.THIRD, 5),
                new Roll(Die.FOURTH, 5),
                new Roll(Die.FIFTH, 5));

        assertThat(diceRoller.roll(previousRoll, Arrays.asList(Die.FIRST, Die.SECOND)), is(expectedRoll));
    }
}
