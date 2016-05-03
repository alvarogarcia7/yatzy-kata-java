package com.dodevjutsu.kata.yatzee.test;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class YatzeeTest {

    Mockery context = new Mockery();

    @Test
    public void produces_game_output() throws Exception {

        Console console = context.mock(Console.class);
        DiceThrower diceThrower = context.mock(DiceThrower.class);
        final Yatzee yatzee = new Yatzee(console, diceThrower);

        context.checking(new Expectations() {{
            oneOf(console).print("Category: Ones");

            atLeast(1).of(diceThrower).roll();
            will(onConsecutiveCalls(
                    returnValue(2),
                    returnValue(4),
                    returnValue(1),
                    returnValue(6),
                    returnValue(1)));
            oneOf(console).print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
            oneOf(console).print("[1] Dice to re-run: ");
            oneOf(console).read(); will(returnValue("D1 D2 D4"));
        }});

        yatzee.play();

        context.assertIsSatisfied();
    }
}
