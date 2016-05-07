package com.dodevjutsu.kata.yatzee.test;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.util.Arrays;

public class YatzeeTest {

    Mockery context = new Mockery();

    @Test
    public void produces_game_output_for_ones() throws Exception {

        Console console = context.mock(Console.class);
        DiceThrower diceThrower = context.mock(DiceThrower.class);
        final Yatzee yatzee = new Yatzee(console, diceThrower);
        yatzee.configureThrows(Arrays.asList(new Ones()));

        context.checking(new Expectations() {{
            oneOf(console).print("Category: Ones");

            atLeast(1).of(diceThrower).roll();
            will(onConsecutiveCalls(
                    returnValue(2), returnValue(4), returnValue(1), returnValue(6), returnValue(1),
                    returnValue(1), returnValue(5), returnValue(2),
                    returnValue(1),returnValue(5)
            ));
            oneOf(console).print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
            oneOf(console).print("[1] Dice to re-run: ");
            oneOf(console).read(); will(returnValue("D1 D2 D4"));
            oneOf(console).print("Dice: D1:1 D2:5 D3:1 D4:2 D5:1");
            oneOf(console).print("[2] Dice to re-run: ");
            oneOf(console).read(); will(returnValue("D2 D4"));
            oneOf(console).print("Dice: D1:1 D2:1 D3:1 D4:5 D5:1");
        }});

        yatzee.play();

        context.assertIsSatisfied();
    }

    @Test
    public void produces_game_output_for_twos() throws Exception {

        Console console = context.mock(Console.class);
        DiceThrower diceThrower = context.mock(DiceThrower.class);
        final Yatzee yatzee = new Yatzee(console, diceThrower);
        yatzee.configureThrows(Arrays.asList(new Twos()));

        context.checking(new Expectations() {{
            oneOf(console).print("Category: Twos");

            atLeast(1).of(diceThrower).roll();
            will(onConsecutiveCalls(
                    returnValue(2), returnValue(4), returnValue(1), returnValue(6), returnValue(1),
                    returnValue(2), returnValue(2), returnValue(5),
                    returnValue(2), returnValue(6)
            ));
            oneOf(console).print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
            oneOf(console).print("[1] Dice to re-run: ");
            oneOf(console).read(); will(returnValue("D2 D3 D5"));
            oneOf(console).print("Dice: D1:2 D2:2 D3:2 D4:6 D5:5");
            oneOf(console).print("[2] Dice to re-run: ");
            oneOf(console).read(); will(returnValue("D4 D5"));
            oneOf(console).print("Dice: D1:2 D2:2 D3:2 D4:2 D5:6");
        }});

        yatzee.play();

        context.assertIsSatisfied();
    }
}
