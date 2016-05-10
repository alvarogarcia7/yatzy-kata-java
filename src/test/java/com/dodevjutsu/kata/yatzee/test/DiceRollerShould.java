package com.dodevjutsu.kata.yatzee.test;

import com.dodevjutsu.kata.yatzee.Dice;
import com.dodevjutsu.kata.yatzee.DiceRoller;
import com.dodevjutsu.kata.yatzee.Die;
import com.dodevjutsu.kata.yatzee.DieRoller;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.dodevjutsu.kata.yatzee.Die.*;
import static com.dodevjutsu.kata.yatzee.Die.SECOND;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DiceRollerShould {

    Mockery context = new Mockery();

    @Test
    public void roll_all_dice() throws Exception {

        DieRoller dieRoller = context.mock(DieRoller.class);

        DiceRoller diceRoller = new DiceRoller(dieRoller);

        context.checking(new Expectations() {{
            exactly(5).of(dieRoller).roll();
            will(onConsecutiveCalls(returnValue(1),
                    returnValue(2),
                    returnValue(2),
                    returnValue(3),
                    returnValue(4)));
        }});

        assertThat(diceRoller.rollAll(), is(new Dice(Arrays.asList(1, 2, 2, 3, 4))));

    }


    @Test
    public void roll_some_dice() throws Exception {

        DieRoller dieRoller = context.mock(DieRoller.class);

        DiceRoller diceRoller = new DiceRoller(dieRoller);

        context.checking(new Expectations() {{
            exactly(2).of(dieRoller).roll();
            will(onConsecutiveCalls(returnValue(5),
                    returnValue(6)));
        }});

        final Dice previousDice = new Dice(Arrays.asList(2, 2, 2, 2, 2));
        final Dice diceToReRun = Dice.fromDice(Arrays.asList(FIRST, SECOND));
        final Dice reRunDice = new Dice(Arrays.asList(5, 6, 2, 2, 2));
        assertThat(diceRoller.roll(previousDice, diceToReRun), is(reRunDice));

    }

}
